import http from "../http-common";
import BorrowData from "../types/Borrow";

const findByIdUser = (id: any) => {
    return http.get<Array<BorrowData>>(`/borrow/user/${id}`);
};
const findByIdItem = (id: any) => {
    return http.get<Array<BorrowData>>(`/borrow/item/${id}`);
};

const BorrowService = {
    findByIdItem,
    findByIdUser
};

export default BorrowService;