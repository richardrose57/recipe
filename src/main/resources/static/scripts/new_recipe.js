Vue.createApp({
    data(){
        return {
            recipe:{},
            recipeTypes: []
        }
    },
    methods:{
        save(){
            this.recipe.image = document.getElementById("recipeImg").src.split(',')[1];
            fetch('http://localhost:8080/api/recipe/save', {
            method: 'PUT',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(this.recipe)
        }).then(res => {
            if (res.ok) {
               alert("mentve")
            } else {
                throw new Error(res.error);
            }
        });

        },
        onFileSelected(event){
            console.log(event.target.files[0]);
            if (event.target.files && event.target.files[0]) {

                var FR= new FileReader();

                FR.addEventListener("load", function(e) {
                    document.getElementById("recipeImg").src = e.target.result;
                });

                FR.readAsDataURL( event.target.files[0] );
            }
        }
    },
    mounted() { fetch('http://localhost:8080/api/recipe/types',{
        method:'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
        }
    }).then(res => {
            if (res.ok){
                return res.json();
            }else{
                throw new Error(res.error);
            }
        }).then(out => this.recipeTypes = out);
    }
}).mount("#new_recipe")