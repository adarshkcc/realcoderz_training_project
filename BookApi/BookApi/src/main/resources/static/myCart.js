/**
 * 
 */

var ourRequest=new XMLHttpRequest();
ourRequest.open('GET','http://localhost:8087/myCart');
ourRequest.onload=function(){
	var ourData=JSON.parse(ourRequest.responseText);
	console.log(ourData);
	renderHTML(ourData);
};


ourRequest.send();

function renderHTML(data)
{ 

	 
	data.map((d)=>{
		var image ='<img src='+d.bookImage+' height="250" width="200">';

		var mydiv=document.getElementById('mydiv');

		mydiv.insertAdjacentHTML('beforeend',
				'<div class="styling">'+ image+'<div class="divjs"><button class="btn btn-outline-info btjs "  value='+d.title+'  onclick="readBook(\''+d.pdf+'\')">'+d.title+'</button></div>'+
				'<div class="divjs"> <button class="btn btn-outline-success btjs" id="download" value="\''+d.pdf+'\'" onclick="download(\''+d.pdf+'\')">Download</button></div>'+
				'<div class="divjs"> <button class="btn btn-outline-danger btjs" onclick="removeBook(\''+d.id+' \')">Remove</button></div></div>');
	})

}


function removeBook(id)
{
	
console.log("you can delete "+id);


$.ajax({
    type : "DELETE",
    url : "/myCart/"+id,
  //  data: {id : id},
  //  contentType: "application/json",
  //  dataType : 'json',
    success: function (result) {       
           console.log(result);  
           alert("item removed")
           window.location="myCart.html";
    },
    error: function (e) {
    	alert("Something went Wrong");
        console.log(e);
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
 function readBook(bookurl)
 {
	 
	 console.log("you can read "+ bookurl)
	 
	 var pdf=bookurl;
	 sessionStorage.setItem("pdf", pdf);
	window.location="readbook.html";
	
 }


 function download(urlname)
 {
	 console.log(url);

	 
	 
	    var url =   urlname;
	    
        $.ajax({
            url: url,
            cache: false,
            xhr: function () {
                var xhr = new XMLHttpRequest();
                xhr.onreadystatechange = function () {
                    if (xhr.readyState == 2) {
                        if (xhr.status == 200) {
                            xhr.responseType = "blob";
                        } else {
                            xhr.responseType = "text";
                        }
                    }
                };
                return xhr;
            },
            success: function (data) {
                //Convert the Byte Data to BLOB object.
                var blob = new Blob([data], { type: "application/octetstream" });

                //Check the Browser type and download the File.
                var isIE = false || !!document.documentMode;
                if (isIE) {
                    window.navigator.msSaveBlob(blob, urlname);
                } else {
                    var url = window.URL || window.webkitURL;
                    link = url.createObjectURL(blob);
                    var a = $("<a />");
                    a.attr("download", urlname);
                    a.attr("href", link);
                    $("body").append(a);
                    a[0].click();
                    $("body").remove(a);
                }
            }
        });
	 
 }










