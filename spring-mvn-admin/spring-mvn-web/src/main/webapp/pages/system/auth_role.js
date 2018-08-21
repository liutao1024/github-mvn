var authRole= function() {

	var handleTable = function(roledata) {
		var authgrid = new Datatable();
		var url = Sunline.ajaxPath("auth/sysAuthRole");
		var editUrl;
		var table = $("#role_auth_ajax");
		var setAuthform = $("#setAuthModal");
		var authTypeDict = Sunline.getDict("D_AUTHTP");
		var authDict = Sunline.getDict(roledata.auth_type, "/auth", "auth_cd", "menu_name");
		$("#Auth_authCd").select2({
			data : authDict
		});
		/*
		 * 初始化table
		 */
		if (!Sunline.isNull(roledata.regist_cd)) {
			authgrid.setAjaxParam('regist_cd', roledata.regist_cd);
		}
		if (!Sunline.isNull(roledata.auth_type)) {
			authgrid.setAjaxParam('auth_type', roledata.auth_type);
		}
		if (!Sunline.isNull(roledata.role_cd)) {
			authgrid.setAjaxParam('role_cd', roledata.role_cd);
		}
		
		authgrid.init({
					src : table,
					deleteData : sendData,
					onSuccess : function(authgrid) {
					},
					onError : function(authgrid) {
					},
					dataTable : { // here you can define a typical
						"ajax" : {
							"url" : url, // ajax source
						},
						"bDestroy" : true,
						"bServerSide" : true,
						"columns" : [
								{
									"data" : "regist_cd",
									"sortable" : false,
									"searchable" : false
								},
								{
									"data" : "auth_type",
									"sortable" : false,
									"searchable" : false,
									"render" : function(data, type, full) {
										for (var i = 0; i < authTypeDict.length; i++) {
											if (authTypeDict[i].id == data) {
												return authTypeDict[i].text;
											}
										}
										return data;
									}
								},
								{
									"data" : "role_cd",
									"sortable" : false,
									"searchable" : false
								},
								{
									"data" : "auth_cd",
									"sortable" : false,
									"searchable" : false,
									"render" : function(data, type, full) {
										for (var i = 0; i < authDict.length; i++) {
											if (authDict[i].id == data) {
												return authDict[i].text;
											}
										}
										return data;
									}
								},
								{
									"data" : null,
									"sortable" : false,
									"searchable" : false,
									"render" : function(data, type, full) {
										return "<a class='delete' href='javascript:;' data-src='"
												+ data.regist_cd
												+ ","
												+ data.auth_type
												+ ","
												+ data.role_cd
												+ ","
												+ data.auth_cd + "'>删除 </a>";
									}
								} ]
					}
				});
		alert("20180821---1");

		var sendData = [ "regist_cd", "auth_type", "role_cd", "auth_cd" ];
		// 绑定删除事件
		authgrid.bindTableDelete(sendData);
		
		//下拉框回收
		$("#setAuthModal").click(function(){
		   	  $(".select-close-1").select2("close");
		     });
		
		// 新增窗口
		$("#add_Auth_btn", $("#add_btn_set")).bind("click", function() {
			$('#Auth_registerCd', setAuthform).val(roledata.registerCd);
			$('#Auth_authType', setAuthform).val(roledata.authType);
			$('#Auth_roleCd', setAuthform).val(roledata.roleCd);
			editUrl = "auth/addRoleAuth";
			setAuthform.modal('show');
			setAuthform.on("hide.bs.modal", function() {
				$(".alert-success", $('form', setAuthform)).hide();
				$('.alert-danger', $('form', setAuthform)).hide();
				$(".msg", $('form', setAuthform)).text("");
				authgrid.submitFilter();
			});
			return false;
		});

		$("#subAuth_btn").click(function() {
			$("#edit_auth_form").submit();
		});

		/*
		 * 表单验证方法
		 */
		var roleValid = Sunline.getValidate($("form", setAuthform), function(form) {
			var data = {};
			$.each($("input", setAuthform), function(i, n) {
				data[n.name] = n.value;
			});

			Sunline.ajaxRouter(editUrl, data, "post", function(data, status) {
				$('.msg', setAuthform).text(data.msg);
				if (data.ret == "success") {
					$('.alert-success', setAuthform).show();
					$('.alert-danger', setAuthform).hide();
					$('#registerCd', setAuthform).attr("readOnly", true);
					$('#authType', setAuthform).attr("readOnly", true);
					$('#roleCd', setAuthform).attr("readOnly", true);
				} else {
					$('.alert-success', setAuthform).hide();
					$('.alert-danger', setAuthform).show();
				}
			}, function() {
				$('.msg', setAuthform).text("请求出错!");
				$('.alert-success', setAuthform).hide();
				$('.alert-danger', setAuthform).show();
			}, "json");
		}, { // 验证规则
			registerCd : {
				required : true,
				rangelength : [ 2, 19 ]
			},
			authType : {
				required : true,
				maxlength : 1,
				number : true
			},
			roleCd : {
				required : true,
				rangelength : [ 2, 19 ]
			},
			authCd : {
				required : true,
				rangelength : [ 2, 19 ]
			}
		});
	}

	return {
		init : function(data) {
			handleTable(data);
		}
	}
}();