Vue.createApp({
    data() {
        return {}
    },
    methods: {
        deleteRecipe() {
            if(window.confirm('Are you sure you want to delete this recipe?')){
                var jsonRecipe = this.createJsonRecipe()
                fetch('http://localhost:8080/delete', {
                    method: 'POST',
                    headers: {
                        'Accept': 'application/json',
                        'Content-Type': 'application/json',
                    },
                    body: JSON.stringify(jsonRecipe)
                }).then(function(response){
                    if (!response.error){
                        alert("Delete Successful");
                    }else{
                        alert("Delete Successful");
                    }
                    window.location = response.url;
                })
            }

        },
        createJsonRecipe() {
            var elements = document.getElementById("recipeModel").children
            return JSON.parse(
                '{ "id":' + '"' + elements["recipeId"].value + '",' +
                '"name":' + '"' + elements["recipeId"].innerHTML + '",' +
                '"type":' + '"' + elements["recipeType"].innerHTML + '",' +
                '"image":' + '"' + elements["recipeImage"].value + '",' +
                '"description":' + '"' + elements["recipeDescription"].innerHTML + '"}'
            );
        }
        // parseToJson(javaClass) {
        //     var classData = javaClass.substr(javaClass.indexOf('('))
        //     console.log(classData.split('image'))
        //     classData = classData.replace(/ /g,'')
        //     classData = classData.replace(/,/g,'","')
        //     classData = classData.replace(/=/g,'":"')
        //     classData = '{"' + classData.slice(1,-1) + '"}'
        //     var jsonRecipe = JSON.parse(classData);
        //     return jsonRecipe;
        // }
    },
    mounted() {
    }
}).mount("#recipe_details")