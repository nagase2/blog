package com.naggi.springboot.lazyinit.inittest.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.naggi.springboot.lazyinit.inittest.data.Customer;
import com.naggi.springboot.lazyinit.inittest.data.User;
import com.naggi.springboot.lazyinit.inittest.service.CustomerService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/customers")
@Slf4j
public class CustomerController {
	private static final Logger log = LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	CustomerService customerService;

	// CustomerFormを初期化する。ModelAttributeをつけたメソッドはコントローラ内の
	// ＠RequestMappingでマッピングされたメソッドの前に実行され、返り値は自動的にModelに設定される
	@ModelAttribute
	CustomerForm setupForm() {
		return new CustomerForm();

	}

	@RequestMapping(method = RequestMethod.GET)
	String list(Model model /* 画面に値を渡すために、Modelオブジェクトを使用する */) {
		List<Customer> customers = customerService.findAll();
		model.addAttribute("customers", customers); // 検索結果をModelに設定。画面からはcustomersを用いてアクセスできる

		log.info("list画面2211133");
		// classpath:templates/+ビュー名＋.htmlが画面のPathとなる。この場合、classpath:templates/customers/list.html
		return "/customers/nagase.html"; // なんでここだけRedirectではないのか
		/*
		 * 仮説：Redirectではない時は、直接このURLにアクセスすることになる。そこには、ファイルが存在している必要がある。
		 */
	}
//
//	@RequestMapping(value = "create", method = RequestMethod.POST)
//	String create(@Validated /* 入力チェックを行うため */CustomerForm form, BindingResult result, Model model,
//			@AuthenticationPrincipal LoginUserDetails userDetails
//	/* これをつけることで ログイン中のLoginUserDetailを取得できる */) {
//		if (result.hasErrors()) {// 入力チェックを行い、エラーがある場合は、List画面に戻る
//			return list(model);
//		}
//		System.out.println("Create method has been calledddd...22dd2.sss3");
//
//		Customer customer = new Customer();
//		// CusomerFormをCustomerにコピーする。画面ではCustomerをそのまま使うこともできるが、
//		// すべての情報を利用するとは限らないため、分けたほうが良い。
//		// beanUtilsの場合は、フィールドの名前と型が同じ場合にしか使えない。柔軟な変換が必要な場合は、DozerやModelMapperの利用を検討する。
//		BeanUtils.copyProperties(form, customer);
//		/* ログインスキップ時のロジック */
////		if (userDetails == null) {
////			log.info("★IDが無いです。★");
////			userDetails = new LoginUserDetails(new User("user2", "", null));
////		}
//		customerService.create(customer, userDetails.getUser());
//		return "redirect:/customers"; // この処理（新規作成）が正常に終了した場合は一覧画面表示にリダイレクト
//
//	}
//
////	@RequestMapping(value = "/bbb")
////	String aaa(@Validated /* 入力チェックを行うため */CustomerForm form, BindingResult result, Model model,
//////			@AuthenticationPrincipal LoginUserDetails userDetails
////	/* これをつけることで ログイン中のLoginUserDetailを取得できる */) {
////		log.info("aaa");
////		return "redirect:/customers"; // この処理（新規作成）が正常に終了した場合は一覧画面表示にリダイレクト
////
////	}
//
////	@RequestMapping(value = "/ccc")
////	String dcc(@Validated /* 入力チェックを行うため */CustomerForm form, BindingResult result, Model model,
////			@AuthenticationPrincipal LoginUserDetails userDetails
////	/* これをつけることで ログイン中のLoginUserDetailを取得できる */) {
////		log.info("ccc");
////		return "redirect:/customers"; // この処理（新規作成）が正常に終了した場合は一覧画面表示にリダイレクト
////
////	}
//
//	/**
//	 * 編集画面を表示する
//	 * 
//	 * @param id
//	 * @param form
//	 * @return
//	 */
//	@RequestMapping(value = "edit", params = "form", method = RequestMethod.GET)
//	String editForm(@RequestParam /*
//									 * RequestParamをつけると、特定のリクエストパラメータをマッピングできる。
//									 * ここではリクエストパラメータのidをIntegerの引数にマッピング
//									 */
//	Integer id, CustomerForm form) {
//		// 編集対象の顧客情報を取得
//		Customer customer = customerService.findOne(id);
//		// 現在の値を画面に表示するため、顧客情報をCustomerFormにコピーする/////
//		BeanUtils.copyProperties(customer, form);
//		System.out.println("show edit screen");
//		return "customers/edit.html";
//	}
//
//	//
//	@RequestMapping(value = "edit", method = RequestMethod.POST)
//	String edit(@RequestParam Integer id, @Validated CustomerForm form, BindingResult result,
//			@AuthenticationPrincipal LoginUserDetails userDetails) {
//		if (result.hasErrors()) {
//			// エラーだったら編集画面を表示
//			return editForm(id, form);
//		}
//		Customer customer = new Customer();
//		BeanUtils.copyProperties(form, customer);
//		customer.setId(id);
//		/* ログインスキップ時のロジック */
//		if (userDetails == null) {
//			userDetails = new LoginUserDetails(new User("user2", "", null));
//		}
//		customerService.update(customer, userDetails.getUser());
//		return "redirect:/customers"; // ? redirectを入れた場合と入れない場合、なにが違うのか？
//	}
//
//	// 顧客編集フォームから一覧表示画面に戻る為のメソッド
//	@RequestMapping(value = "edit", params = "goToTop")
//	String goToTop() {
//		return "redirect:/customers";
//	}
//
//	@RequestMapping(value = "delete", method = RequestMethod.POST)
//	String delete(@RequestParam Integer id) {
//		customerService.delete(id);
//		return "redirect:/customers";
//	}

}

