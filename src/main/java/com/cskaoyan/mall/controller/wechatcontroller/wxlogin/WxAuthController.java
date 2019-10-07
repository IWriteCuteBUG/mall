package com.cskaoyan.mall.controller.wechatcontroller.wxlogin;



import com.cskaoyan.mall.bean.BaseRespVo;
import com.cskaoyan.mall.bean.Order;
import com.cskaoyan.mall.mallstart.util.UserTokenManager;
import com.cskaoyan.mall.realm.CustomToken;
import com.cskaoyan.mall.realm.wxtokenvo.OrderInfo;
import com.cskaoyan.mall.realm.wxtokenvo.UserInfo;
import com.cskaoyan.mall.realm.wxtokenvo.WxBaseVo;
import com.cskaoyan.mall.service.wechatservice.zyp.WxAuthService;
import com.cskaoyan.mall.utils.adminutils.ExtensionStringUtils;
import com.cskaoyan.mall.vo.adminvo.tvo.LoginVo;
import com.cskaoyan.mall.vo.wechatvo.zyp.UserIndexVo;
import com.cskaoyan.mall.vo.wechatvo.zyp.WeChatRegisterVo;
import com.sun.org.apache.xalan.internal.lib.Extensions;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sun.misc.Request;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by little Stone
 * Date 2019/7/8 Time 20:55
 */
@RestController
@RequestMapping("/wx")
public class WxAuthController {

	@Autowired
	WxAuthService wxAuthService;

	@RequestMapping("auth/login")
	@ResponseBody
//	public Object login(@RequestBody String body, HttpServletRequest request) {
//	public Object login(@RequestBody LoginVo loginVo , HttpServletRequest request) {
	public Object login(@RequestBody LoginVo loginVo) {
		String username = loginVo.getUsername();
		String password = loginVo.getPassword();
		CustomToken token = new CustomToken(username, password, "wechat");
		try {
			SecurityUtils.getSubject().login(token);
		} catch (AuthenticationException e) {
			return BaseRespVo.baseRespErr(500,"用户名或密码错误");
		}
		Integer userId = wxAuthService.queryIdByUsername(username);
//		request.getSession().setAttribute("userId",userId);
		Subject subject = SecurityUtils.getSubject();
		subject.getSession().setAttribute("userId",userId);
		Serializable id = subject.getSession().getId();
		WxBaseVo wxBaseVo = new WxBaseVo();
		UserInfo userInfo = new UserInfo();
		userInfo.setNickName(username);
		userInfo.setAvatarUrl("");
		wxBaseVo.setUserInfo(userInfo);
		wxBaseVo.setToken(id);
		wxBaseVo.setTokenExpire(new Date());
		return BaseRespVo.baseRespOk(wxBaseVo);
		/*UserInfo userInfo = new UserInfo();
		userInfo.setNickName("wx");
		userInfo.setAvatarUrl("");
		Map<Object, Object> result = new HashMap<Object, Object>();
		result.put("token", "qo0jdbwrja22i2ld5zvws9z6hlin39vh");
		result.put("tokenExpire", "2019-10-05T08:22:49.604");
		result.put("userInfo", userInfo);*/
//		return BaseRespVo.ok(result);
	}

	@RequestMapping("auth/register")
	public BaseRespVo register(@RequestBody WeChatRegisterVo registerVo){
		BaseRespVo baseRespVo = wxAuthService.insertUser(registerVo);
		return baseRespVo;
//		return BaseRespVo.baseRespOk("");
	}

//	手机获取验证码
	@RequestMapping("auth/regCaptcha")
	public BaseRespVo regCaptcha(@RequestBody Map map){
		String mobile = (String) map.get("mobile");
		if (ExtensionStringUtils.isEmpty(mobile)) {
			return BaseRespVo.baseRespErr(702,"请您输入手机号！");
		}
//		随机生成一个验证码
		int code = (int) ((Math.random()*9+1)*100000);
		Session session = SecurityUtils.getSubject().getSession();
		session.setAttribute("code",code);
		Serializable id = session.getId();
//		System.out.println(id);
		wxAuthService.regCaptcha(mobile,code);
		return BaseRespVo.baseRespOk(id);
	}

	@RequestMapping("auth/logout")
	public BaseRespVo logout(HttpServletRequest request){
		Subject subject = SecurityUtils.getSubject();
		request.getSession().setAttribute("userId","");
		subject.logout();
		return BaseRespVo.baseRespOk("退出成功");
	}
//	个人主页
	@GetMapping("user/index")
	public BaseRespVo list() {
		OrderInfo orderInfo = new OrderInfo();
		HashMap<String, OrderInfo> map = new HashMap<>();
		Integer userId = (Integer) SecurityUtils.getSubject().getSession().getAttribute("userId");
		if (userId == null) {
			orderInfo.setUncomment(0);
			orderInfo.setUnrecv(0);
			orderInfo.setUnpaid(0);
			orderInfo.setUnship(0);
			map.put("order", orderInfo);
			return BaseRespVo.ok(map);
		}
//		未付款 0
		List<Order> unpaid = wxAuthService.queryOrdersByUserIdAndOrderStatus(userId,0);
//		待发货
		List<Order> unship = wxAuthService.queryOrdersByUserIdAndOrderStatus(userId,1);
//		待收货
		List<Order> unrecv = wxAuthService.queryOrdersByUserIdAndOrderStatus(userId,2);
//		待评价
		List<Order> uncomment = wxAuthService.queryOrdersByUserIdAndOrderStatus(userId,3);
		orderInfo.setUncomment(uncomment.size());
		orderInfo.setUnrecv(unrecv.size());
		orderInfo.setUnpaid(unpaid.size());
		orderInfo.setUnship(unship.size());
		map.put("order", orderInfo);
		/*UserIndexVo userIndexVo = new UserIndexVo();
		userIndexVo.setOrder(orderInfo);*/
		return BaseRespVo.ok(map);
	}

	//    重置密码
	@RequestMapping("auth/reset")
	public BaseRespVo reset(@RequestBody WeChatRegisterVo weChatRegisterVo) {
		BaseRespVo baseRespVo = wxAuthService.reset(weChatRegisterVo);
		return baseRespVo;
	}
}
