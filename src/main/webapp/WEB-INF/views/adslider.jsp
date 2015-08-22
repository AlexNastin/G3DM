<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="row nomargin">
	<div class="col-md-3"></div>
	<div id="carousel-example-generic" class="carousel slide col-md-6"
		data-ride="carousel">
		<!-- Indicators -->
		<ol class="carousel-indicators">
			<li data-target="#carousel-example-generic" data-slide-to="0"
				class="active"></li>
			<c:forEach var="i" begin="1" end="${sizeAdvertisements-1}">
				<li data-target="#carousel-example-generic" data-slide-to="${i}"></li>
			</c:forEach>
		</ol>

		<!-- Wrapper for slides -->
		<div class="carousel-inner">
			<div class="item active">
				<div style="text-align: center">
					<img src=<c:url value="${listAdvertisements[0].filePath}" />
						alt="..." style="max-height: 20em; max-width: 30em;">
				</div>
				<div class="carousel-caption">
					<h3>${listAdvertisements[0].title}</h3>
						<p>${listAdvertisements[0].description}</p>
				</div>
			</div>
			<c:forEach items="${listAdvertisements}" var="advertisements"
				begin="1">
				<div class="item">
					<div style="text-align: center">
						<img src=<c:url value="${advertisements.filePath}" /> alt="..."
							style="max-height: 20em; max-width: 30em;">
					</div>
					<div class="carousel-caption">
						<h3>${advertisements.title}</h3>
						<p>${advertisements.description}</p>
					</div>
				</div>
			</c:forEach>
		</div>

	</div>
	<div class="col-md-3"></div>
</div>
