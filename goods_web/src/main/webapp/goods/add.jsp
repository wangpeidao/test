<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>预约详情页</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="utf-8">

<link href="${pageContext.request.contextPath }/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
<link href="${pageContext.request.contextPath }/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet" media="screen">
<link href="${pageContext.request.contextPath }/bootstrap/css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">

<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.11.3.js" charset="UTF-8"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/bootstrap/js/bootstrap-datetimepicker.js" charset="UTF-8"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/bootstrap/js/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>


	<script type="text/javascript">
		/* 日期插件 */
		$(function(){
			$('.form_date').datetimepicker({
		        language:  'zh-CN',
		        weekStart: 1,
		        todayBtn:  1,
				autoclose: 1,
				todayHighlight: 1,
				startView: 2,
				minView: 2,
				forceParse: 0
		    });
			/*页面加载完成时,查询分类信息*/
            Category();
		});
		//查询分类信息
		function Category() {
			$.ajax({
				method:"get",
				url:"/category/findAllCategory",
				dataType:"json",//一处text
				statusCode:{
				    200:function (data) {
				        //页面初始化时
				        $("#cid").html("<option>-- 请选择分类 --</option>")

						//遍历追加
						$(data).each(function (index) {
                            $("#cid").append('<option value="'+this.cid+'">'+this.cname+'</option>')
                        })

                    },
					500:function (data) {

                    }
				}
			})
        };
		//校验商品名
		function checkPname(pname) {

		    if (pname != '' && pname != undefined){

                $.ajax({
                    method:"get",
                    url:"/goods/checkPname/"+pname,
                    dataType:"text",
                    statusCode:{
                        200:function (data) {
                            var  a =$("#add");
								if(data == "true"){
								    //商品可用
									$("#checkName").html("商品名称可用!")
							         a.prop("disabled",false);

								}else{
								    //商品不可用
                                    $("#checkName").html("商品名称不可用!")
                                    a.prop("disabled",true);

								}

                        },
                        500:function (data) {

                        }
                    }
                })

			}
        }
		
	</script>

</head>
<body>
	<div class="container">
		<div class="panel panel-default">
			<div class="panel-heading text-center">
				<h2>商品添加</h2>
			</div>

			<!-- 商品添加form表单 -->
			<form action="/goods/addGoods" method="post">
			
				<div class="panel-body">
					<table class="table table-hover">
						<tbody>
							<div class="row">
								<div class="col-md-6">
									<div class="form-group">
										<label for="goods_name">商品名称</label>
										<input type="text" name="goods_name" value="" class="form-control" id="goods_name" placeholder="商品名称" onblur="checkPname(this.value)">
									</div>
									<div id="checkName">
										<!-- 输入数量鼠标离焦后，此处展示商品名称是否可用提示信息 -->
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label for="cid">商品分类</label>
										<select name="cid" id="cid" class="form-control">
											<!--	<option>-- 请选择分类 --</option>
											<option>蔬菜类</option>
											<option>水果类</option>
											<option>肉食类</option> -->
										</select>
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label for="goods_number">商品数量</label>
										<input type="text" name="goods_number" value="" class="form-control" id="goods_number" placeholder="商品数量">
									</div>
								</div>

								<div class="col-md-6">
									<div class="form-group">
										<label for="goods_price">商品价格</label>
										<input type="text" name="goods_price" value="" class="form-control" id="goods_price" placeholder="商品价格">
									</div>
								</div>
								
								<div class="col-md-6">
									<div class="control-group">
						                <label class="control-label">保质期</label>
						                <div class="controls input-append date form_date" data-date="" data-date-format="yyyy-mm-dd" data-link-field="guarantee_period" data-link-format="yyyy-mm-dd">
						                    <input size="26" type="text" value="" readonly>
						                    <span class="add-on"><i class="icon-remove"></i></span>
											<span class="add-on"><i class="icon-th"></i></span>
						                </div>
						                <!-- 保质期：选择日期会自动赋值给下面输入框value-->
										<input type="hidden" id="guarantee_period" name="guarantee_period" value="" /><br/>
									</div>
								</div>

							</div>
						</tbody>

					</table>
				</div>
				<div class="panel-body text-center">

					<!-- 表单提交按钮 -->
					<button type="submit" class="btn btn-primary btn-lg"  id="add" disabled="disabled">
						<span class="glyphicon glyphicon-copy" aria-hidden="true"></span>
						添加商品
					</button>

				</div>
			</form>
		</div>

	</div>


</body>


</html>
