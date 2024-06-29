
function doSearch(){
	var searchText = $("#search_txt").val();
	var countryCode = $('#country_code').find(":selected").val();
	if(searchText == "" || countryCode == 0){
		alert("Please enter proper informations");
	}else{	
		$('#response_list').empty();
		$.ajax({
			type: 'GET',
			url: '/movieList/'+searchText+'/'+countryCode,
			success: function(data){
				var resultList = data.results;
				if(resultList.length == 0){
					alert("Sorry cannot find movies. Please try another");
				}else{
					generateHtml(resultList);
				}
			},
			statusCode: {
				503: function(){
					alert("Service is down now. Please wait");
				}
			},
			error: function(jqXHR, textStatus, errorThrown) {
			    alert("We are facing some issues. Don't worry we will be back soon..");
			}
		});
	}
}

function generateHtml(resultlist){
	for(i=0; i<resultlist.length;i++){
		$('#response_list').append(singleMovieHtml(resultlist[i]));
	}
}

function singleMovieHtml(movie){
	var movieHtml = `
		<div class="row border border-light rounded">
			<div id="movie_img"
				class="col-lg-6 order-lg-1">
				<img class="img-fluid" src=${movie.picture}></img>
			</div>
			<div class="col-lg-6 order-lg-2 my-auto">
				<h2 class="text-center" id="movie_name">${movie.name}</h2>
				<br>
`	
	movieHtml = movieHtml + locationHtml(movie.locations)								
	movieHtml = movieHtml + detailsHtml(movie.external_ids)	
	return movieHtml;			
}

function locationHtml(locations){
	var locationCode = `
		<h4>Watch the movie here:</h4>
		<br>
		<div class="container-fluid">
			<div class="row">
		`		
	for(j = 0; j<locations.length; j++){
			locationCode = locationCode + `			
			<div class="col-md-3 col-6">
				<a
					href="${locations[j].url}"
					target="_blank"> <img alt=""
					src="${locations[j].icon}">
				</a>
			</div>
		`		
		}
		
	locationCode = locationCode + `		
		</div>
			</div>
			<br>
	`
	return locationCode;
}

function detailsHtml(external_ids){
	var detailsCode = `
		<h4>For Details:</h4>
		<br>
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-3 col-6">
					<a
						href="${external_ids.imdb.url}"
						target="_blank"> <img alt=""
						src="/FrontEnd/img/imdb-logo.png">
					</a>
				</div>
				<div class="col-md-3 col-6">
					<a
						href="${external_ids.tmdb.url}"
						target="_blank"> <img alt=""
						src="/FrontEnd/img/tmdb_icon.png">
					</a>
				</div>
				<div class="col-md-3 col-6">
					<a
						href="${external_ids.wiki_data.url}"
						target="_blank"> <img alt=""
						src="/FrontEnd/img/wikidata_logo.png">
					</a>
				</div>
			</div>
			<br>
		</div>
	</div>
</div>
		`
	return detailsCode;
}








