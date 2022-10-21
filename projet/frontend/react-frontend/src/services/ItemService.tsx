import http from "../http-common";
import ItemData from "../types/Item";

const getAll = (sortBy: string) => {
    return http.get<Array<ItemData>>(`/items${sortBy}`);
};

const findByTitleOrAuthor = (search: string) =>  {
    return http.get<Array<ItemData>>(`/search=${search}`);
}
const findById = (id: any) => {
    return http.get<ItemData>(`/item${id}`);
}

const findByNameItem = (name: string) => {
    return http.get<Array<ItemData>>(`/${name}`);
}

const ItemService = {
    getAll,
    findByTitleOrAuthor,
    findById,
    findByNameItem
};

export default ItemService;