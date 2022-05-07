function loadDoc() {
   $.ajax({
        type: "Get",
        url: "https://asi2-backend-market.herokuapp.com/cards",
        dataType: 'json',
        success: function(result){
            $('#imgPreview').attr('src', result[result.length - 2].imgUrl)
            console.log(result[result.length - 2].imgUrl)   
            
       }
       
   })
    
  }