import http from "../http-common";
import BorrowData from "../types/Borrow";
import ItemData from "../types/Item";

const getAll = (sortBy: string) => {
    return http.get<Array<ItemData>>(`/items${sortBy}`);
};

const findByTitleOrAuthor = (search: string) =>  {
    return http.get<Array<ItemData>>(`/search=${search}`);
};

const findById = (id: any) => {
    return http.get<ItemData>(`/item${id}`);
};

const findByNameItem = (name: string) => {
    return http.get<Array<ItemData>>(`/${name}`);
};

const findBorrow = (id: any) => {
    return http.get<Array<ItemData>>(`/items/borrow/${id}`);
};

const ItemService = {
    getAll,
    findByTitleOrAuthor,
    findById,
    findByNameItem,
    findBorrow
};

export default ItemService;