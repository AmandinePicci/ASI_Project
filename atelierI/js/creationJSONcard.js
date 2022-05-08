 
async function postName() {

                                const object = { name: document.querySelector("input[name='name']").value,
                                    description: document.querySelector("input[name='description']" ).value,
                                    family: document.querySelector("input[name='family']").value,
                                    affinity: document.querySelector("input[name='affinity']").value,
                                    imgUrl: document.querySelector("input[name='imgUrl']").value,
                                    smallImgUrl: document.querySelector("input[name='smallImgUrl']").value,
                                    energy: document.querySelector("input[name='energy']").value,
                                    hp: document.querySelector("input[name='hp']").value,
                                    defence: document.querySelector("input[name='defence']").value,
                                    attack: document.querySelector("input[name='attack']").value
                                }
                    
                                ;

                                const response = await fetch('https://asi2-backend-market.herokuapp.com/card', {
                                                            method: 'POST',     
                                                            body: JSON.stringify(object),
                                                            headers: {
                                                                 'Content-Type': 'application/json'
                                                                }
                                                            });
                                const responseText = await response.text();
                                window.location.href = "../html/affichageCard.html";

                                console.log(responseText); // logs 'OK'
}