import axios from 'axios';

// THIS IS NOT NEEDED ANYMORE!!!!
// const axios = axios.create({
//   baseURL: "axios://localhost:8080"
// });

export default {

    getBooks(){
        return axios.get('/list');
    },

    getBookById(bookID){
        return axios.get(`/books/${bookID}`).then((response) =>{
            const books = response.data.books;
            return books.find(book => book.id == bookID)
        })
        
    },

    createBook(newBook){
        return axios.post('/add-book', newBook)
    },

    addBookToMyList(bookToMyList){
        return axios.post('/user/add-book', bookToMyList)

    },

    deleteBookFromMyList(removeBook){
        return axios.delete('/user/delete-book', removeBook)
    },

    // added token - please change
    viewSavedList(){
        return axios.get('/user/list')
    }


}

// import list from 'axios://localhost:8080/list'
// export default{
    // data(){
//         return{
//             myList: list
//         }
//     }
// }

  //  <div>
   //     <div v-for="data in $options.myList">{{data}}</div>
   // </div>
