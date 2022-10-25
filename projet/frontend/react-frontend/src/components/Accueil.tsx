import React, { useState, useEffect, ChangeEvent } from "react";
import { Link } from 'react-router-dom';
import ItemService from "../services/ItemService";
import ItemData from "../types/Item";


import { BsSearch } from 'react-icons/bs';

const ItemsList: React.FC = () => {

    const [items, setItems] = useState<Array<ItemData>>([]);
    const [search, setSearch] = useState("");

    const findByTitleOrAuthor = () => {
        ItemService.findByTitleOrAuthor(search)
            .then((response: any) => {
                setItems(response.data);
            })
            .catch((e: Error) => {
                console.log(e.message);
            });
    };
    const onChangeSearch = (e: ChangeEvent<HTMLInputElement>) => {
        setSearch(e.target.value);
    };

    const retrieveItems = () => {
        ItemService.getAll('')
            .then((response: any) => {
                setItems(response.data);
            })
            .catch((e: Error) => {
                console.log(e);
            });
    };

    const setSortType = (e: ChangeEvent<HTMLSelectElement>) => {
        switch (e.target.value) {
            case '':
                ItemService.getAll("").then((response: any) => {
                    setItems(response.data);
                })
                    .catch((e: Error) => {
                        console.log(e.message);
                    });
                break;
            case 'title':
                ItemService.getAll("sortByTitle").then((response: any) => {
                    setItems(response.data);
                })
                    .catch((e: Error) => {
                        console.log(e.message);
                    });
                break;
            case 'author':
                ItemService.getAll("sortByAuthor").then((response: any) => {
                    setItems(response.data);
                })
                    .catch((e: Error) => {
                        console.log(e);
                    });
                break;
            case 'dateRelease':
                ItemService.getAll("sortByDateRelease").then((response: any) => {
                    setItems(response.data);
                })
                    .catch((e: Error) => {
                        console.log(e.message);
                    });
                break;
        }
    }

    useEffect(() => {

        retrieveItems();
    }, []);

    return (
        <div className="main main-raised">
            <div className="section">
                <div className="container">
                    <div className="row">
                        <div className="col-md-3">
                            <div className="card card-refine">
                                <div className="card-body">
                                    <h4 className="card-title"></h4>
                                    <div>
                                        <div className="input-group mb-3">
                                            <input
                                                type="text"
                                                className="form-control"
                                                placeholder="Recherche par titre ou auteur"
                                                value={search}
                                                onChange={onChangeSearch}
                                            />
                                            <div className="input-group-append">
                                                <button
                                                    className="btn btn-outline-secondary"
                                                    type="button"
                                                    onClick={findByTitleOrAuthor}
                                                >
                                                    <BsSearch />
                                                </button>
                                            </div>
                                        </div>
                                        <div className="card">
                                            <label>Trier par :</label>
                                            <select className="form-select" onChange={(e) => setSortType(e)}>
                                                <option value="">Nouveauté</option>
                                                <option value="title">Titre</option>
                                                <option value="author">Auteur</option>
                                                <option value="dateRelease">Date Parution</option>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div className="col-md-9">
                            <div className="row">
                                {items && items.map((item, index) => (
                                    <div className="col-md-4" key={index}>
                                        {item.quantity > 0 && (
                                            <div className="card card-product card-plain no-shadow">
                                                <div className="card-header card-header-image">
                                                    <img className="image img-thumbnail border-0" src={"/images/" + item.image} alt="img_item" />
                                                </div>
                                                <div className="card-body">
                                                    <h4 className="card-title text-primary text-capitalize">
                                                        <Link to={"/item/" + item.id}>
                                                            {item.title}
                                                        </Link>
                                                    </h4>
                                                    <h5 className="card-category text-capitalize">{item.author}</h5>
                                                    <p className="card-description ">{item.description.substring(0, 60)}...
                                                        <Link className="btn font-weight-bold" to={"/item/" + item.id}>
                                                            Voir plus
                                                        </Link>
                                                    </p>
                                                </div>
                                            </div>
                                        )}
                                    </div>
                                ))}
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default ItemsList;