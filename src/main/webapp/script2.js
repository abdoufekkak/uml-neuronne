function matrix(ligne,colonne)
{
  var i = 0;
  var j = 0;
  var matrix = document.getElementById('matrix');
  var table = document.createElement('table');
  var b = document.createElement('button'); 

  var a = document.getElementById('entree');
  a.removeChild(document.getElementById('ligne'));

  b.appendChild(document.createTextNode("valider"));
  b.setAttribute('type','submit');
  b.setAttribute('class',"btn btn-success mb-2");
  a.appendChild(b);
  matrix.appendChild(table);

  
  while(i < ligne){
    var tr = document.createElement('tr');
    j=0;
    while(j < colonne){
        var td = document.createElement('td');
        var input = document.createElement('input');
        input.setAttribute('name','x'+i+j);
        td.appendChild(input);
        tr.appendChild(td);
    j++;
  }
  i++;
  table.appendChild(tr);
  }

}