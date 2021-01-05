Vue.createApp({
    data(){
        return {
            allRecipes: []
        }
    },
    methods: {
      open(id){
          window.location = "http://localhost:8080/recipe_details?id="+id;
      }
    },
    mounted() {
        fetch('http://localhost:8080/api/recipe/all_recipes', {
            method: 'GET',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json',
            }
        }).then(res => res.json())
            .then(out => this.allRecipes = out);

    }
}).mount("#all_recipes")