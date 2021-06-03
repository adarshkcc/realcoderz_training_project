var received_books=[];
var ourRequest=new XMLHttpRequest();
ourRequest.open('GET','http://localhost:8087/api/books');
ourRequest.onload=function(){
	var data=JSON.parse(ourRequest.responseText);
	console.log(data)
	var str="";
	for(var i=0;i<data.length;i++)
		for(var j=0;j<data[i].books.length;j++){
			console.log(data[i].books[j].bookUrl);
			var image ='<img src='+data[i].books[j].bookUrl+' height="250" width="200">';

			str+='<div class="styling">'+ image+'<div class="divjs"><button class="btn btn-outline-info btjs "  value='+data[i].books[j].title+'  onclick="getBookDetails(\''+data[i].books[j].title+'\')">'+data[i].books[j].title+'</button></div></div>';
			/*mydiv.insertAdjacentHTML('beforeend',
					'<div class="styling">'+ image+'<div class="divjs"><button class="btn btn-outline-info btjs "  value='+data[i].books[j].title+'  onclick="getBookDetails(\''+data[i].books[j].title+'\')">'+data[i].books[j].title+'</button></div></div>');
		*/}
	var mydiv=document.getElementById('mydiv');
	mydiv.innerHTML=str;
	
};



ourRequest.send();
var category="";


function clickedCategory(clicked)
{

	 category=	clicked;


	var ourRequest=new XMLHttpRequest();
	ourRequest.open('GET','http://localhost:8087/api/books');
	ourRequest.onload=function(){
		var data=JSON.parse(ourRequest.responseText);
		
console.log(data)
var str="";
				for(var i=0;i<data.length;i++)
					for(var j=0;j<data[i].books.length;j++){
						if(data[i].books[j].category== category)
						{

						var image ='<img src='+data[i].books[j].bookUrl+' height="250" width="200">';
						
						str+=
							'<div class="styling">'+ image+'<div class="divjs"><button class="btn btn-outline-info btjs "  value='+data[i].books[j].title+'  onclick="getBookDetails(\''+data[i].books[j].title+'\')">'+data[i].books[j].title+'</button></div></div>';
						/*mydiv.insertAdjacentHTML('beforeend',
								'<div class="styling">'+ image+'<div class="divjs"><button class="btn btn-outline-info btjs "  value='+data[i].books[j].title+'  onclick="getBookDetails(\''+data[i].books[j].title+'\')">'+data[i].books[j].title+'</button></div></div>');
					*/}
						var mydiv=document.getElementById('mydiv');
						mydiv.innerHTML=str;

			}

	};
	ourRequest.send();

}


function getBookDetails(title)
{
	console.log("my "+title);

	var ourRequest=new XMLHttpRequest();
	ourRequest.open('GET','http://localhost:8087/api/books');
	ourRequest.onload=function(){
		var ourData=JSON.parse(ourRequest.responseText);



		ourData.map((d)=>{
              d.books.map((b)=>{

			if(b.title== title)
			{


				var image ='<img src='+b.bookUrl+' height="250" width="300">';

				var mydiv=document.getElementById('mydiv');

				mydiv.innerHTML	= '<div class="styling">'+ image+'<div class="divjs"><button class=" btn btn-outline-info btjs">'+b.title+'</button></div>'+
				'<div class="divjs"><button class=" btn btn-outline-info btjs">'+'Description : '+b.desc+'</button></div>'+
				'<div class="divjs"><button class=" btn btn-outline-info btjs">'+'Price : '+b.price+' Rs'+'</button></div>'+
				'<div class="divjs"><button class=" btn btn-outline-info btjs">'+ 'Author : '+d.author_name+'</button></div>'+
				'<div class="divjs"><button class=" btn btn-outline-info btjs">'+ 'Category : '+b.category+'</button></div>'+
				'<div class="divjs"><button class=" btn btn-outline-info btjs">'+'Rating : '+b.rating+'</button></div>'+
				'</div><button class=" btn btn-danger " onclick="addToCart(\''+b.title+'\',\''+b.price+'\',\''+b.bookUrl+'\',\''+b.pdf+'\')">Add To Cart</button><a href="bookdetails.html"><button class=" btn btn-success ">HOME</button></a>';


			}
              });

		});


	};
	ourRequest.send();

}

function addToCart(title,price,bookImage,pdf)
{
console.log("hey you"+ title+" "+price+" "+bookImage);	

var goingdata={
		title:title,
		price:price,
		bookImage:bookImage,
		pdf:pdf
		
}
console.log(goingdata);
$.ajax({
	type:"POST",
	contentType:"application/json",
	url :"/addToCart",
	data:JSON.stringify(goingdata),
	dataType: 'json',
	success:function(comingdata){
		console.log(comingdata);
		
		alert("Added to cart");
	
	},
	error:function(e){
		alert("error");
	}
})
}

function removeAllBook(){
	
	var ourRequest=new XMLHttpRequest();
	ourRequest.open('GET','http://localhost:8087/myCart/removeAll');
	ourRequest.onload=function(){
		var ourData=JSON.parse(ourRequest.responseText);
		console.log(ourData);
		
	};


	ourRequest.send();
	
}

