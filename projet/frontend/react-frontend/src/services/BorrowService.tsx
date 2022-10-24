import http from "../http-common";
import BorrowData from "../types/Borrow";

const findByIdUser = (id: any) => {
    return http.get<Array<BorrowData>>(`/borrow/user/${id}`);
};
const findByIdItem = (id: any) => {
    return http.get<Array<BorrowData>>(`/borrow/item/${id}`);
};

const returnBorrow = (id: any) => {
    return http.put<BorrowData>(`/borrow/return/${id}`);
}

const BorrowService = {
    findByIdItem,
    findByIdUser,
    returnBorrow
};

export default BorrowService;