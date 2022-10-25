import http from "../http-common";
import BorrowData from "../types/Borrow";

const findByIdUser = (id: any) => {
    return http.get<Array<BorrowData>>(`/borrow/user/${id}`);
};
const findByIdItem = (id: any) => {
    return http.get<Array<BorrowData>>(`/borrow/item/${id}`);
};
const returnBorrow = (id: any, quantity: number) => {
    return http.put<BorrowData>(`/borrow/update/${id}/${quantity}`);
};
const newBorrow = (idUser: any, idItem: any) => {
    return http.post(`/borrow/new/${idUser}/${idItem}`);
};

const BorrowService = {
    findByIdItem,
    findByIdUser,
    returnBorrow,
    newBorrow
};

export default BorrowService;