import axios from 'axios';

const http = axios.create({
  baseURL: "http://localhost:8080"
});

export default {

    getBooks(){
        return http.get('/books');
    },

    getBookById(bookID){
        return http.get(`/books/${bookID}`).then((response) =>{
            const books = response.data.books;
            return books.find(book => book.id == bookID)
        })
        
    },

}