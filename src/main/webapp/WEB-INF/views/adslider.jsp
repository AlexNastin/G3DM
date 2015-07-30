<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="row nomargin">
	<div class="col-md-3"></div>
	<div id="carousel-example-generic" class="carousel slide col-md-6"
		data-ride="carousel">
		<!-- Indicators -->
		<ol class="carousel-indicators">
			<li data-target="#carousel-example-generic" data-slide-to="0"
				class="active"></li>
			<li data-target="#carousel-example-generic" data-slide-to="1"></li>
			<li data-target="#carousel-example-generic" data-slide-to="2"></li>
		</ol>

		<!-- Wrapper for slides -->
		<div class="carousel-inner">
			<div class="item active">
				<img src=<c:url value="${listAdvertisements[0].filePath}" /> alt="...">
				<div class="carousel-caption">
					<h3>${listAdvertisements[0].title}</h3>
				</div>
			</div>
			<c:forEach items="${listAdvertisements}" var="advertisements" begin="1">
			<div class="item">
				<img src=<c:url value="${advertisements.filePath}" /> alt="...">
				<div class="carousel-caption">
					<h3>${advertisements.title}</h3>
				</div>
			</div>
			</c:forEach>
		</div>

	</div>
	<div class="col-md-3"></div>
</div>
