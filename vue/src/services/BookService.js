import axios from 'axios';

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
        return axios.delete('/user/delete-book',{data: removeBook})
    },

    viewSavedList(){
        return axios.get('/user/list')
    },

    viewCurrentlyReadingBooks() {
        return axios.get( '/user/currently-reading' );
    },

    updateCurrentlyReading( book ) {
        return axios.put( `/user/${parseInt(book.book_id)}`, book )
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
