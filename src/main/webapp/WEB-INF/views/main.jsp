<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Global3Dmod</title>
<!-- After -->

 <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="global3dmod team">
    <title>Global 3d Mod | Site</title>
    <link href="<c:url value="/resources/css/bootstrap.css"  />" rel="stylesheet" />
    <link href="<c:url value="/resources/css/font-awesome.min.css"  />" rel="stylesheet" />
    <link href="<c:url value="/resources/css/prettyPhoto.css"  />" rel="stylesheet" />
    <link href="<c:url value="/resources/css/main.css"  />" rel="stylesheet" />
    <link href="<c:url value="/resources/css/slick/slick.css"  />" rel="stylesheet" />
    <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->
   </head>
<body>
	

<!-- AAAAAAAAAAAAAFTER!!!! -->

<nav class="navbar navbar-default">
    <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-collapse-2">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Brand</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="navbar-collapse-2">
            <ul class="nav navbar-nav navbar-left">
                <!-- put some links here -->
                </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#">About</a></li>
                <li><a href="#">Services</a></li>
                <li><a href="#">Works</a></li>
                <li><a href="#">News</a></li>
                <li><a href="#">Contact</a></li>
                <li><a class="supernav" href="?locale=en">EN |</a>
                <li><a href="?locale=ru">RU</a></li>
                    <li><button type="button" class="btn btn-default btn-outline btn-circle" onClick='location.href="<c:url value="/signup" />"'>
      <spring:message code="signin.signup" />
      </button>
                </li>
            </ul>

        </div><!-- /.navbar-collapse -->
    </div><!-- /.container -->
</nav><!-- /.navbar -->
<div class="banner">
    <div class="container_wrap">
        <h1>What are you looking for?</h1>
        <form>
            <input type="text" class="searchline" value="Type your query here" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Type your query here';}">
            <div class="contact_btn">
                <label class="btn1 btn-2 btn-2g"><input name="submit" type="submit" id="submit" value="Search"></label>
            </div>
        </form>
        <div class="clearfix"></div>
    </div>
</div>
    <section id="portfolio">
        <div class="container">
<center><h1>Categories</h1></center>
            <div class="row portfolio-items"> <!--1st element-->
                <div class="portfolio-item apps  col-md-3">
                        <div class="item-inner">
                            <div class="portfolio-image">
                                <img src=<c:url value="/resources/images/auto.jpg" /> alt="">
                                <div class="overlay container">
                                    <div class="menuis">
                                    <a class="preview btn btn-primary" title="Lorem ipsum dolor sit amet">Avtomobilpppe</a>
                                    <p><a href="dsfds">mexico</a></p>
                                    </div>
                                </div>
                            </div>
                            <h5>Lorem ipsum dolor sit amet</h5>
                        </div>
                    </div>
                    <!--/.portfolio-item 2 -->
                <div class="portfolio-item apps  col-md-3">
                    <div class="item-inner">
                        <div class="portfolio-image">
                             <img src=<c:url value="/resources/images/auto.jpg" /> alt="">
                            <div class="overlay container">
                                <div class="menuis">
                                    <a class="preview btn btn-primary" title="Lorem ipsum dolor sit amet">Avtomobilpppe</a>
                                    <p><a href="dsfds">mexico</a></p>
                                </div>
                            </div>
                        </div>
                        <h5>Lorem ipsum dolor sit amet</h5>
                    </div>
                </div>
                     <!--/.portfolio-item 3 -->
                <div class="portfolio-item apps  col-md-3">
                    <div class="item-inner">
                        <div class="portfolio-image">
                             <img src=<c:url value="/resources/images/auto.jpg" /> alt="">
                            <div class="overlay container">
                                <div class="menuis">
                                    <a class="preview btn btn-primary" title="Lorem ipsum dolor sit amet">Avtomobilpppe</a>
                                    <p><a href="dsfds">mexico</a></p>
                                </div>
                            </div>
                        </div>
                        <h5>Lorem ipsum dolor sit amet</h5>
                    </div>
                </div>
                 <!--/.portfolio-item 4 -->
                         <div class="portfolio-item apps col-md-3">
                     <div class="item-inner">
                         <div class="portfolio-image">
                             <img src=<c:url value="/resources/images/auto.jpg" /> alt="">
                             <div class="overlay container">
                                 <div class="menuis">
                                     <a class="preview btn btn-primary" title="Lorem ipsum dolor sit amet">Avtomobile</a>
                                     <p><a href="dsfds">mexico</a></p>
                                 </div>
                             </div>
                         </div>

                         <h5>Lorem ipsum dolor sit amet</h5>
                     </div>
                             </div>
                         </div>
            <div class="row portfolio-items">
                <!--1st element-->
                <div class="portfolio-item apps  col-md-3">
                    <div class="item-inner">
                        <div class="portfolio-image">
                            <img src=<c:url value="/resources/images/auto.jpg" /> alt="">
                            <div class="overlay container">
                                <div class="menuis">
                                    <a class="preview btn btn-primary" title="Lorem ipsum dolor sit amet">Avtomobilpppe</a>
                                    <p><a href="dsfds">mexico</a></p>
                                </div>
                            </div>
                        </div>
                        <h5>Lorem ipsum dolor sit amet</h5>
                    </div>
                </div>
                <!--/.portfolio-item 2 -->
                <div class="portfolio-item apps  col-md-3">
                    <div class="item-inner">
                        <div class="portfolio-image">
                             <img src=<c:url value="/resources/images/auto.jpg" /> alt="">
                            <div class="overlay container">
                                <div class="menuis">
                                    <a class="preview btn btn-primary" title="Lorem ipsum dolor sit amet">Avtomobilpppe</a>
                                    <p><a href="dsfds">mexico</a></p>
                                </div>
                            </div>
                        </div>
                        <h5>Lorem ipsum dolor sit amet</h5>
                    </div>
                </div>
                <!--/.portfolio-item 3 -->
                <div class="portfolio-item apps  col-md-3">
                    <div class="item-inner">
                        <div class="portfolio-image">
                             <img src=<c:url value="/resources/images/auto.jpg" /> alt="">
                            <div class="overlay container">
                                <div class="menuis">
                                    <a class="preview btn btn-primary" title="Lorem ipsum dolor sit amet">Avtomobilpppe</a>
                                    <p><a href="dsfds">mexico</a></p>
                                </div>
                            </div>
                        </div>
                        <h5>Lorem ipsum dolor sit amet</h5>
                    </div>
                </div>
                <!--/.portfolio-item 4 -->
                <div class="portfolio-item apps col-md-3">
                    <div class="item-inner">
                        <div class="portfolio-image">
                            <img src=<c:url value="/resources/images/auto.jpg" /> alt="">
                            <div class="overlay container">
                                <div class="menuis">
                                    <a class="preview btn btn-primary" title="Lorem ipsum dolor sit amet">Avtomobile</a>
                                    <p><a href="dsfds">mexico</a></p>
                                </div>
                            </div>
                        </div>

                        <h5>Lorem ipsum dolor sit amet</h5>
                    </div>
                </div>
            </div>
            <!--3rd line-->
            <div class="row portfolio-items">
                <!--1st element-->
                <div class="portfolio-item apps  col-md-3">
                    <div class="item-inner">
                        <div class="portfolio-image">
                            <img src=<c:url value="/resources/images/auto.jpg" /> alt="">
                            <div class="overlay container">
                                <div class="menuis">
                                    <a class="preview btn btn-primary" title="Lorem ipsum dolor sit amet">Avtomobilpppe</a>
                                    <p><a href="dsfds">mexico</a></p>
                                </div>
                            </div>
                        </div>
                        <h5>Lorem ipsum dolor sit amet</h5>
                    </div>
                </div>
                <!--/.portfolio-item 2 -->
                <div class="portfolio-item apps  col-md-3">
                    <div class="item-inner">
                        <div class="portfolio-image">
                             <img src=<c:url value="/resources/images/auto.jpg" /> alt="">
                            <div class="overlay container">
                                <div class="menuis">
                                    <a class="preview btn btn-primary" title="Lorem ipsum dolor sit amet">Avtomobilpppe</a>
                                    <p><a href="dsfds">mexico</a></p>
                                </div>
                            </div>
                        </div>
                        <h5>Lorem ipsum dolor sit amet</h5>
                    </div>
                </div>
                <!--/.portfolio-item 3 -->
                <div class="portfolio-item apps  col-md-3">
                    <div class="item-inner">
                        <div class="portfolio-image">
                             <img src=<c:url value="/resources/images/auto.jpg" /> alt="">
                            <div class="overlay container">
                                <div class="menuis">
                                    <a class="preview btn btn-primary" title="Lorem ipsum dolor sit amet">Avtomobilpppe</a>
                                    <p><a href="dsfds">mexico</a></p>
                                </div>
                            </div>
                        </div>
                        <h5>Lorem ipsum dolor sit amet</h5>
                    </div>
                </div>
                <!--/.portfolio-item 4 -->
                <div class="portfolio-item apps col-md-3">
                    <div class="item-inner">
                        <div class="portfolio-image">
                             <img src=<c:url value="/resources/images/auto.jpg" /> alt="">
                            <div class="overlay container">
                                <div class="menuis">
                                    <a class="preview btn btn-primary" title="Lorem ipsum dolor sit amet">Avtomobile</a>
                                    <p><a href="dsfds">mexico</a></p>
                                </div>
                            </div>
                        </div>

                        <h5>Lorem ipsum dolor sit amet</h5>
                    </div>
                </div>
            </div>
                         </div>

<center><h1>Our top models</h1></center>

    </section><!--/#portfolio-->
    <div id=carousel>
        <figure id=spinner>
            <img src=//demosthenes.info/assets/images/wanaka-tree.jpg alt="">
            <img src=//demosthenes.info/assets/images/still-lake.jpg alt="">
            <img src=//demosthenes.info/assets/images/pink-milford-sound.jpg alt="">
            <img src=//demosthenes.info/assets/images/paradise.jpg alt="">
            <img src=//demosthenes.info/assets/images/morekai.jpg alt="">
            <img src=//demosthenes.info/assets/images/milky-blue-lagoon.jpg alt="">
            <img src=//demosthenes.info/assets/images/lake-tekapo.jpg alt="">
            <img src=//demosthenes.info/assets/images/milford-sound.jpg alt="">
        </figure>
    </div>
    <span style=float:left class=ss-icon onclick="galleryspin('-')">&lt;</span>
    <span style=float:right class=ss-icon onclick="galleryspin('')">&gt;</span>

<div class="footer">
    <div class="container">

        <div class="footer_grids">
            <div class="footer-grid">
                <h4>Ipsum Quis</h4>
                <ul class="list1">
                    <li><a href="contact.html">Contact</a></li>
                    <li><a href="#">Mirum est</a></li>
                    <li><a href="#">placerat facer</a></li>
                    <li><a href="#">claritatem</a></li>
                    <li><a href="#">sollemnes </a></li>
                </ul>
            </div>
            <div class="footer-grid">
                <h4>Quis Ipsum</h4>
                <ul class="list1">
                    <li><a href="#">placerat facer</a></li>
                    <li><a href="#">claritatem</a></li>
                    <li><a href="#">sollemnes </a></li>
                    <li><a href="#">Claritas</a></li>
                    <li><a href="#">Mirum est</a></li>
                </ul>
            </div>
            <div class="clearfix"> </div>
        </div>
    </div>
</div>
    <script src="<c:url value="/resources/js/jquery-2.1.1.js" />"> </script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"> </script>
    <script src="<c:url value="/resources/js/slick/slick.min.js" />"> </script>
    <!---<script src="js/jquery.isotope.min.js"></script>--->
    <!--<script src="js/jquery.prettyPhoto.js"></script>-->
    <script src="<c:url value="/resources/js/main.js" />"> </script>
    
</body>
</html>
