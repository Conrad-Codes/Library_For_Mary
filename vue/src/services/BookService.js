import axios from 'axios';

const http = axios.create({
  baseURL: "http://localhost:8080"
});

export default {

    getBooks(){
        return http.get('/list');
    },

    getBookById(bookID){
        return http.get(`/books/${bookID}`).then((response) =>{
            const books = response.data.books;
            return books.find(book => book.id == bookID)
        })
        
    },

    createBook(newBook){
        return http.post('/add-book', newBook)
    },

    addBookToMyList(bookToMyList){
        return http.post('/user/add-book', bookToMyList)

    },

    deleteBookFromMyList(removeBook){
        return http.delete('/user/delete-book', removeBook)
    },

    viewSavedList(){
        return http.get('/user/list')
    }

}

// import list from 'http://localhost:8080/list'
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
