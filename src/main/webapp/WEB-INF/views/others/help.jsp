<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<link
	href="<c:url value="/resources/css/fontawesome430/css/font-awesome.css"  />"
	rel="stylesheet" />
<link href="<c:url value="/resources/css/main.css"  />" rel="stylesheet" />
<link href="<c:url value="/resources/css/otherpage.css"  />"
	rel="stylesheet" />
<link rel="icon" href="<c:url value="/resources/images/favicon.png" />"
	type="image/x-icon">
<meta name="keywords"
	content="3d printer, 3d model, 3d model free, 3d model download, 3d model download free, model to print 3d printer free, stl, stl download,stl download free, 3d designer, 3d model robot, 3д модель, 3д принтер, 3д модель скачать, 3д модель скачать напечатать, 3д дизайнер, stl бесплатные, stl скачать, global3dmod, global 3d mod ">

<title>FAQ | Global3dMod</title>
<spring:message code="headerWithSearch.header.search" var="search" />
</head>
<body>
	<%@include file="/WEB-INF/views/header/headerWithSearch.jsp"%>
	<div class="container holycontent">
		<div class="row">
			<div class="font-contact line-contact col-md-12">FAQ</div>
			<div class="container text-align-justify">
				<ul class="nav nav-tabs">
					<li class="active"><a data-toggle="tab" href="#home">In
							English</a></li>
					<li><a data-toggle="tab" href="#menu1">На русском языке</a></li>

				</ul>
				<div class="tab-content">
					<div id="home" class="tab-pane fade in active">
						<div class="col-md-12">
							<div class="col-md-12">
								<div class="col-md-1">
									<i class="fa fa-question-circle fa-5x"></i>
								</div>
								<div class="col-md-11">
									<div class="text-help-page-q col-md-12">Q: What can I do
										after registration?</div>
									<div class="text-help-page-a col-md-12">A: Registration
										allows all users, regardless of their role, to comment all the
										3d-models, to mark the 3d-models as a favorite, as well as to
										mark the models that User considers contrary to the rules of
										the site.</div>
								</div>
							</div>
							<div class="col-md-12">
								<div class="col-md-1">
									<i class="fa fa-question-circle fa-5x"></i>
								</div>
								<div class="col-md-11">
									<div class="text-help-page-q col-md-12">Q: I like one of
										3d-model so how I can add it to bookmarks?</div>
									<div class="text-help-page-a col-md-12">A: The site
										visitor who has the role of the user can mark 3d-model that he
										likes by clicking the "Like this" under the photo of model.
										After that, the model will be displayed in the user's personal
										account on the "My bookmarks" page.</div>

								</div>
							</div>
							<div class="col-md-12">
								<div class="col-md-1">
									<i class="fa fa-question-circle fa-5x"></i>
								</div>
								<div class="col-md-11">
									<div class="text-help-page-q col-md-12">В: I can not log
										in. It seems that I have cracked. What do I do???</div>
									<div class="text-help-page-a col-md-12">A: First, try to
										reset the password on the login page. If access to the mailbox
										is lost, contact Support.</div>

								</div>
							</div>
							<div class="col-md-12">
								<div class="col-md-1">
									<i class="fa fa-question-circle fa-5x"></i>
								</div>
								<div class="col-md-11">
									<div class="text-help-page-q col-md-12">Q: Why is your
										site has a models that I've seen on other websites?</div>
									<div class="text-help-page-a col-md-12">A: The models on
										our website is not only a works of registred on our site
										Designers, it is also a models taken from open sources and
										with licenses for freely use. We respect the work of designers
										and to each of these models, we specify the resource from
										which it was taken and the author's name (or Nickname) of the
										model.</div>
								</div>
							</div>
							<div class="col-md-12">
								<div class="col-md-1">
									<i class="fa fa-question-circle fa-5x"></i>
								</div>
								<div class="col-md-11">
									<div class="text-help-page-q col-md-12">Q: Why this site
										isn’t fully translated to Russian language?</div>
									<div class="text-help-page-a col-md-12">A: This site is
										not fully translated to Russian, only the interface. That is
										made for giving an opportunity to Russian-speaking people to
										understand the basic idea and to take a first insight into
										this site.</div>
								</div>
							</div>
						</div>
					</div>


				<div id="menu1" class="tab-pane fade">
					
						<div class="col-md-12">
							<div class="col-md-1">
								<i class="fa fa-question-circle fa-5x"></i>
							</div>
							<div class="col-md-11">
								<div class="text-help-page-q col-md-12">В: Что даёт
									регистрация на сайте?</div>
								<div class="text-help-page-a col-md-12">О: Регистрация
									даёт возможность всем пользователям, независимо от их роли,
									комментировать 3d-модели, отмечать 3d-модели как понравившиеся,
									а так же отмечать модели, которые Пользователь считает
									противоречащими правилам сайта.</div>
							</div>
						</div>
						<div class="col-md-12">
							<div class="col-md-1">
								<i class="fa fa-question-circle fa-5x"></i>
							</div>
							<div class="col-md-11">
								<div class="text-help-page-q col-md-12">В: Мне нравится
									одна 3d-модель, как сделать так, чтобы её не искать каждый раз?
								</div>
								<div class="text-help-page-a col-md-12">О: Посетитель
									сайта, который имеет роль Пользователя может отметить
									3d-модель, которая ему нравится, нажав кнопку "Нравится" под
									фото модели. После этого данная модель будет отображаться в
									Личном кабинете Пользователя на вкладке "Мои закладки"</div>

							</div>
						</div>
						<div class="col-md-12">
							<div class="col-md-1">
								<i class="fa fa-question-circle fa-5x"></i>
							</div>
							<div class="col-md-11">
								<div class="text-help-page-q col-md-12">В: Не могу войти
									на сайт. Кажется, меня взломали. Что делать???</div>
								<div class="text-help-page-a col-md-12">О: Для начала,
									попробуйте сбросить пароль на странице Входа. Если доступ к
									почтовому ящику утерян, свяжитесь со службой поддержки
									Пользователей.</div>

							</div>
						</div>
						<div class="col-md-12">
							<div class="col-md-1">
								<i class="fa fa-question-circle fa-5x"></i>
							</div>
							<div class="col-md-11">
								<div class="text-help-page-q col-md-12">В: Почему на вашем
									сайте есть модели, которые я видел на других сайтах?</div>
								<div class="text-help-page-a col-md-12">О: Модели на нашем
									сайте это не только авторские работы Дизайнеров сайта, это ещё
									и модели взятые из открытых источников с лицензией на свободное
									использование. Мы уважаем труд Дизайнеров и к каждой такой
									модели мы указываем ресурс с которого она была взята и автора
									модели.</div>
							</div>
						</div>
						<div class="col-md-12">
							<div class="col-md-1">
								<i class="fa fa-question-circle fa-5x"></i>
							</div>
							<div class="col-md-11">
								<div class="text-help-page-q col-md-12">В: Почему сайт не
									полностью переведён на русский язык?</div>
								<div class="text-help-page-a col-md-12">О: На русский язык
									переведён только пользовательский интерфейс, для ознакомления с
									сайтом и лучшего понимания его принципов работы рускоязычными
									пользователями.</div>

							</div>
						</div>
					</div>



				</div>

				</div>
			</div>
		</div>
	<%@include file="/WEB-INF/views/footer.jsp"%>
	<script src="<c:url value="/resources/js/jquery-2.1.4.min.js" />">
		
	</script>
	<script src="<c:url value="/resources/js/bootstrap.min.js" />">
		
	</script>
	<script>
		(function(i, s, o, g, r, a, m) {
			i['GoogleAnalyticsObject'] = r;
			i[r] = i[r] || function() {
				(i[r].q = i[r].q || []).push(arguments)
			}, i[r].l = 1 * new Date();
			a = s.createElement(o), m = s.getElementsByTagName(o)[0];
			a.async = 1;
			a.src = g;
			m.parentNode.insertBefore(a, m)
		})(window, document, 'script',
				'//www.google-analytics.com/analytics.js', 'ga');
		ga('create', 'UA-66505156-1', 'auto');
		ga('send', 'pageview');
	</script>
	<!-- Yandex.Metrika counter -->
	<script type="text/javascript">
		(function(d, w, c) {
			(w[c] = w[c] || []).push(function() {
				try {
					w.yaCounter32035491 = new Ya.Metrika({
						id : 32035491,
						clickmap : true,
						trackLinks : true,
						accurateTrackBounce : true
					});
				} catch (e) {
				}
			});

			var n = d.getElementsByTagName("script")[0], s = d
					.createElement("script"), f = function() {
				n.parentNode.insertBefore(s, n);
			};
			s.type = "text/javascript";
			s.async = true;
			s.src = "https://mc.yandex.ru/metrika/watch.js";

			if (w.opera == "[object Opera]") {
				d.addEventListener("DOMContentLoaded", f, false);
			} else {
				f();
			}
		})(document, window, "yandex_metrika_callbacks");
	</script>
	<noscript>
		<div>
			<img src="https://mc.yandex.ru/watch/32035491"
				style="position: absolute; left: -9999px;" alt="" />
		</div>
	</noscript>
	<!-- /Yandex.Metrika counter -->
</body>
</html>