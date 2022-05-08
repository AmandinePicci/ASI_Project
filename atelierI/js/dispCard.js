function loadDoc() {
    $.ajax({
        type: "Get",
        url: "https://asi2-backend-market.herokuapp.com/cards",
        dataType: 'json',
        success: function(result){
            if(result == []){
                console.log("Aucune image ne corespond à votre recherche")

            } else{

                var canvas = document.querySelector('.myCanvas');
                var width = canvas.width = 450;
                var height = canvas.height = 675;
                var ctx = canvas.getContext('2d');

                var image = new Image();
                image.src = result[result.length - 1].imgUrl
            
                ctx.strokeRect(0, 0, width, height/10);
                ctx.font = '20px serif';
                ctx.fillText(result[result.length - 1].name, width/2 - 50, height/10 - 30)

                ctx.strokeRect(0, height/10, width, 5*height/10);
                image.onload = function() {
                    ctx.drawImage(image, 0, 0, image.width, image.height, 5, height/10, width-10, 5*height/10 - 10);
                }

                ctx.strokeRect(0, 6*height/10, width, 4*height/10);    
                ctx.fillText(result[result.length - 1].energy, 50, 6*height/10 + 30)
                
            }
            /*$('#imgPreview').attr('src', result[result.length - 1].imgUrl);
            console.log(result[result.length - 1].imgUrl);
            */
       }
       
   })
    
  }