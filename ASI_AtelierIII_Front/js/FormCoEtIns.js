

async function SubmitFormInscription (){
    var username = document.getElementById("userName")[0].value;
    var mdp = document.getElementById("mdp")[0].value;
    var argent = document.getElementById("argent")[0].value;

    var Inscriptionjson = { 
        "userName":username,
        "argent":argent,
        "mdp":mdp,
        "cardList":[]
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

    
    //window.location.href = "marketing.html";

}


async function Test(){
    const response = await fetch('http://localhost:8081/jeu/getUserByUsername/Amandine', {
                                method: 'GET',     
                                });
    const responseText = await response.text();

    console.log(responseText);

    
    window.location.href = "http://127.0.0.1:5500/ASI_AtelierIII_Front/html/marketing.html";
}


async function AboutMe(){

    var username=document.getElementsByClassName("username")[0].value;
    var lien =  'http://localhost:8081/jeu/getUserByUsername/'+username;

    console.log(username);
    const response = await fetch(lien, {
                                method: 'GET',     
                                });
    const responseText = await response.text();

    console.log(responseText);

    
}