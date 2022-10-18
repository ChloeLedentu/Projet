import ItemData from "./Item";

export default interface DvdData extends ItemData{
    duration : number;
    type: string;
}