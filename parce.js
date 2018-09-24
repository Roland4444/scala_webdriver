document.querySelectorAll(".doc-text")[5].parentNode.innerText

GET TEXT =>:
var z1, A1=document.querySelectorAll(".doc-text"); for (z1=0; z1<A1.length; z1++) { console.log(A1[z1].parentNode.innerText); }
GET LINK =>:
var z1, A1=document.querySelectorAll(".doc-text"); console.log(A1[5].querySelectorAll("A")[0].href);



if (driver.isInstanceOf[JavascriptExecutor])
    driver.asInstanceOf[JavascriptExecutor].executeScript("alert(\"Hi\")")

    heading = document.createElement("h1");
           heading_text = document.createTextNode("Big Head!");
           heading.appendChild(heading_text);
           document.body.appendChild(heading);