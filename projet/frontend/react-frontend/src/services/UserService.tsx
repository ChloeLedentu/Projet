import http from "../http-common";
import BorrowData from "../types/Borrow";
import UserData from "../types/User";

const findByEmail = (email: string) => {
    return http.get<Array<UserData>>(`/profil/${email}`);
};

const findBorrow = (id: any) => {
    return http.get<Array<BorrowData>>(`/user/borrow/${id}`);
};

const UserService = {
    findByEmail,
    findBorrow
};

export default UserService;