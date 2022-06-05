

async function SubmitFormInscription (){
    var username = document.getElementById("userName");
    var mdp = document.getElementById("mdp");
    var argent = document.getElementById("argent");

    var Inscriptionjson = { 
        userName:username,
        argent:argent,
        mdp:mdp,
        cardList:[]
    }


    const response = await fetch('http://localhost:8081/jeu/addUser', {
                                method: 'POST',     
                                body: JSON.stringify(Inscriptionjson),
                                headers: {
                                     'Content-Type': 'application/json'
                                    }
                                });
    const responseText = await response.text();

    console.log(responseText);

    
    window.location.href = "marketing.html";

}