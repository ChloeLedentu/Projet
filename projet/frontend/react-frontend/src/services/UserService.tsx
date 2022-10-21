import http from "../http-common";
import UserData from "../types/User";

const findByEmail = (email: string) => {
    return http.get<Array<UserData>>(`/profil/${email}`);
};

const ItemService = {
    findByEmail,
};

export default ItemService;