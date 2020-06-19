$( function() {
                $( "#slider-range" ).slider({
                    range: true,
                    min: 0,
                    max: 500,
                    values: [ 75, 300 ],
                    slide: function( event, ui ) {
                        $( "#amount" ).val( "$" + ui.values[ 0 ] + " - $" + ui.values[ 1 ] );
                    }
                });
                $( "#amount" ).val( "$" + $( "#slider-range" ).slider( "values", 0 ) +
                    " - $" + $( "#slider-range" ).slider( "values", 1 ) );
            } );

        
        function loadImg(value){
        
	        if(value.files && value.files[0])  {
	            
	            var reader = new FileReader();
	            
	            reader.onload = function(e){
	                $('#contentImg').attr('src', e.target.result);
	            }
	            reader.readAsDataURL(value.files[0]);
	        }
        }
       