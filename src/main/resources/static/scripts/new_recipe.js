Vue.createApp({
    data(){
        return {
            recipe:{},
            recipeTypes: []
        }
    },
    methods:{
        save(){ fetch('http://localhost:8080/api/recipe/save', {
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
        }).then(out => this.recipeTypes = out)
    }
}).mount("#new_recipe")