
$("body").ready(function() {
	
	grid("player", "leftGrid");
	grid("enemy", "rightGrid");
	
	makeMiss("A5", "player");
	makeHit("B3", "player");
	makeDestroyed("F6", "player");
	setTimeout(function(){resetCell("F6", "player");}, 2000);

});

function grid(gridid, destination) {
	
	var cellSize = 60;
	
	var table = $(document.createElement("table"));
	table.css("border-collapse", "collapse");
	table.css("margin", "auto");
	table.attr("id", gridid);
	
	for(var j=0; j<7; j++) {
		
		var row = $(document.createElement("tr"));
		
		for(var i=0; i<7; i++) {
			
			var cell = $(document.createElement("td"));
			cell.attr("id", ("cell" + j) + i);
			cell.css("width", cellSize + "px").css("height", cellSize + "px");
			cell.css("text-align", "center");
			if(i != 0 || j != 0) {
				
				cell.css("border", "1px solid black");
			}
			
			if(j == 0) {
				
				cell.css("height", cellSize/2 + "px");
				
			}
			if(i == 0) {
				
				cell.css("width", cellSize/2 + "px");
				
			}
			
			row.append(cell);
		}
		
		table.append(row);
	}
	
	$("#" + destination).append(table);
	
	var tab = ["A", "B", "C", "D", "E", "F"];
	for(var i=1; i<7; i++) {
		
		$("#" + gridid + " #cell0" + i).html(tab[i-1]);
		$("#" + gridid + " #cell" + i + "0").html(i);
	}
	
}

function makeMiss(cell, gridid) {
	
	setCell(cell, gridid, "red");
	
}

function makeHit(cell, gridid) {
	
	setCell(cell, gridid, "green");
}

function makeDestroyed(cell, gridid) {
	
	setCell(cell, gridid, "blue");
}

function resetCell(cell, gridid) {
	
	setCell(cell, gridid, "white");
}

function setCell(cell, gridid, color) {
	
	var x = cell.charAt(1);
	var y = val(cell.charAt(0));
	
	$("#" + gridid + (" #cell" + x) + y).css("background-color", color);
}

function val(char) {
	
	switch(char) {
	
	case "A": return 1;
	case "B": return 2;
	case "C": return 3;
	case "D": return 4;
	case "E": return 5;
	case "F": return 6;
		
	}
	
	return -1;
}








