
    $(document).ready(function() {
			$.getJSON('/api/books', function(json) {
				var tr=[];
				tr.push('<tr>');
				tr.push('<td>Book Title</td>');
				tr.push('<td>Published date</td>');
				tr.push('<td>Description</td>');
				tr.push('<td>Price</td>');
				tr.push('<td>rating</td>');
				

				
				tr.push('</tr>');
				for (var i = 0; i < json.length; i++) {
					tr.push('<tr>');
					tr.push('<td>' + json[i].title + '</td>');
					tr.push('<td>' + json[i].date + '</td>');
					tr.push('<td>' + json[i].desc + '</td>');
					tr.push('<td>' + json[i].price+ '</td>');
					tr.push('<td>' + json[i].rating + '</td>');
					

					tr.push('<td><button>Edit</button>&nbsp;&nbsp;<button id=' + json[i].id + '>Delete</button></td>');
					tr.push('</tr>');
				}
				$('table').append($(tr.join('')));
			});
    });
	
