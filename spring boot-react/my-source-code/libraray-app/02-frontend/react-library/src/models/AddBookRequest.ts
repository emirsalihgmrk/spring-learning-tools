class AddBookRequest{
    title: string;
    author: string;
    descriptipn: string;
    copies: number;
    category: string;
    img?: string;

    constructor(title: string, author: string, descriptipn: string, copies: number, category: string){
        this.title = title;
        this.author = author;
        this.descriptipn = descriptipn;
        this.copies = copies;
        this.category = category;
    }
}

export default AddBookRequest;