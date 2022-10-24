import ItemData from "./Item";

export default interface BorrowData {
    id?: any,
    dateTake: Date,
    dateReturn: Date,
    quantity: number,
    items: Array<ItemData>
   
}