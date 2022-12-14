import React, { useState, ChangeEvent } from "react";
import { NavigateFunction, useNavigate } from 'react-router-dom';
import { Formik, Field, Form, ErrorMessage } from "formik";
import * as Yup from "yup";
import logo from '../logo.svg';
import { login } from "../services/AuthService";

type Props = {}

const Login: React.FC<Props> = () => {
    let navigate: NavigateFunction = useNavigate();

    const initialValues: { username: string; password: string; } = { username: "", password: "" };
    const [loading, setLoading] = useState<boolean>(false);
    const [message, setMessage] = useState<string>("");

    const validationSchema = Yup.object().shape({
        username: Yup.string().required("Ce champ est requis!"),
        password: Yup.string().required("Ce champ est requis!"),
    });

    const handleLogin = (formValue: { username: string; password: string }) => {
        const { username, password } = formValue;
        setMessage("");
        setLoading(true);

        login(username, password).then(
            () => {
                navigate("/profil");
                window.location.reload();
            },
            (error) => {
                const resMessage =
                    (error.response &&
                        error.response.data &&
                        error.response.data.message) ||
                    error.message ||
                    error.toString();

                setLoading(false);
                setMessage(resMessage);
            }
        );

    };

    return (

        <div className="container">
            <div className="row">
                <div className="col-md-12 ml-auto mr-auto">
                    <div className="card card-container">
                    <img src={logo} className="App-logo" alt="logo" />
                        <h2 className="card-title text-center">Connexion</h2>
                        <Formik
                            initialValues={initialValues}
                            validationSchema={validationSchema}
                            onSubmit={handleLogin}
                        >
                            <Form>
                                <div className="form-group">
                                    <label htmlFor="email">Email</label>
                                    <Field name="username" type="text" className="form-control" />
                                    <ErrorMessage
                                        name="username"
                                        component="div"
                                        className="alert alert-danger"
                                    />
                                </div>

                                <div className="form-group">
                                    <label htmlFor="password">Password</label>
                                    <Field name="password" type="password" className="form-control" />
                                    <ErrorMessage
                                        name="password"
                                        component="div"
                                        className="alert alert-danger"
                                    />
                                </div>

                                <div className="form-group">
                                    <button type="submit" className="btn btn-primary btn-block" disabled={loading}>
                                        {loading}
                                        Se connecter
                                    </button>
                                </div>

                                {message && (
                                    <div className="form-group">
                                        <div className="alert alert-danger" role="alert">
                                            {message}
                                        </div>
                                    </div>
                                )}
                            </Form>
                        </Formik>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default Login;