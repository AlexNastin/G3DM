<div class="row placeForAds"> </div> 
<nav class="navbar navbar-default">
    <div class="container">
        <!-- Brand and toggle get grouped for better mobile and tablet display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-collapse-2">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="<c:url value="/"  />">Global3Dmod</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="navbar-collapse-2">
            <form class="navbar-form navbar-left" role="search">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="Search">
        </div>
        <button type="submit" class="btn btn-default">${search}</button>
      </form>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="<c:url value="/about"/>"><spring:message code="main.about" /></a></li>
                <li><a href="<c:url value="/designer"/>"><spring:message code="main.servises" /></a></li>
                <li><a href="<c:url value="/addPost"/>"><spring:message code="main.works" /></a></li>
                <li><a href="#"><spring:message code="main.news" /></a></li>
                <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Partners <span class="caret"></span></a>
          <ul class="dropdown-menu" role="menu">
            <li><a href="#">3d-hunters</a></li>
            <li><a href="#">print-me.org</a></li>
            <li><a href="#">you-do.info</a></li>
            <li class="divider"></li>
            <li><a href="#">hey-designer.me</a></li>
            <li class="divider"></li>
            <li><a href="#">One-3d.net</a></li>
          </ul>
        </li>
                <li><a href="<c:url value="/contact"/>"><spring:message code="main.contact" /></a></li>
                <li><a class="supernav" href="?locale=en">EN |</a>
                <li><a href="?locale=ru">RU</a></li>
                    <li><button type="button" class="btn btn-default btn-outline btn-circle" onClick='location.href="<c:url value="/go/signin" />"'>
      <spring:message code="main.signin" />
      </button>
                </li>
            </ul>

        </div><!-- /.navbar-collapse -->
    </div><!-- /.container -->
</nav><!-- /.navbar -->    
