import React, { useState } from "react";
import logo from '../logo.svg';
import { Formik, Field, Form, ErrorMessage } from "formik";
import * as Yup from "yup";

import IUser from "../types/User";
import { register } from "../services/AuthService";

const Register: React.FC = () => {
  const [successful, setSuccessful] = useState<boolean>(false);
  const [message, setMessage] = useState<string>("");

  const initialValues: IUser = {
    email: "",
    firstname: "",
    lastname: "",
    password: ""
  };

  const validationSchema = Yup.object().shape({
    firstname: Yup.string()
      .test(
        "len",
        "Le prénom doit contenir entre 3 et 20 caractères",
        (val: any) =>
          val &&
          val.toString().length >= 3 &&
          val.toString().length <= 20
      )
      .required("Ce champ est requis!"),
      lastname: Yup.string()
      .test(
        "len",
        "Le nom doit contenir entre 3 et 20 caractères",
        (val: any) =>
          val &&
          val.toString().length >= 3 &&
          val.toString().length <= 20
      )
      .required("Ce champ est requis!"),
    email: Yup.string()
        .test(
            "len",
            "L'email doit contenir entre 3 et 20 caractères",
            (val: any) =>
            val &&
            val.toString().length >= 3 &&
            val.toString().length <= 20
        )
      .email("Email invalide")
      .required("Ce champ est requis!"),
    password: Yup.string()
      .test(
        "len",
        "Le mot de passe doit contenir entre 6 et 40 caractères",
        (val: any) =>
          val &&
          val.toString().length >= 6 &&
          val.toString().length <= 40
      )
      .required("Ce champ est requis!"),
  });

  const handleRegister = (formValue: IUser) => {
    const {email, firstname,lastname,  password} = formValue;
    
    register(email, firstname, lastname, password).then(
      (response) => {
        setMessage(response.data.message);
        setSuccessful(true);
      },
      (error) => {
        const resMessage =
          (error.response &&
            error.response.data &&
            error.response.data.message) ||
          error.message ||
          error.toString();

        setMessage(resMessage);
        setSuccessful(false);
      }
    );
  };

  return (
    <div className="col-md-12">
      <div className="card card-container">
      <img src={logo} className="App-logo" alt="logo" />
      <h2 className="card-title text-center">Inscription</h2>
        <Formik
          initialValues={initialValues}
          validationSchema={validationSchema}
          onSubmit={handleRegister}
        >
          <Form>
            {!successful && (
              <div>
                <div className="form-group">
                  <label htmlFor="lastname"> Nom </label>
                  <Field name="lastname" type="text" className="form-control" />
                  <ErrorMessage
                    name="lastname"
                    component="div"
                    className="alert alert-danger"
                  />
                </div>
                <div className="form-group">
                  <label htmlFor="firstname"> Prénom </label>
                  <Field name="firstname" type="text" className="form-control" />
                  <ErrorMessage
                    name="firstname"
                    component="div"
                    className="alert alert-danger"
                  />
                </div>

                <div className="form-group">
                  <label htmlFor="email"> Email </label>
                  <Field name="email" type="email" className="form-control" />
                  <ErrorMessage
                    name="email"
                    component="div"
                    className="alert alert-danger"
                  />
                </div>

                <div className="form-group">
                  <label htmlFor="password"> Mot de Passe </label>
                  <Field
                    name="password"
                    type="password"
                    className="form-control"
                  />
                  <ErrorMessage
                    name="password"
                    component="div"
                    className="alert alert-danger"
                  />
                </div>

                <div className="form-group">
                  <button type="submit" className="btn btn-primary btn-block">S'enregistrer</button>
                </div>
              </div>
            )}

            {message && (
              <div className="form-group">
                <div
                  className={
                    successful ? "alert alert-success" : "alert alert-danger"
                  }
                  role="alert"
                >
                  {message}
                </div>
              </div>
            )}
          </Form>
        </Formik>
      </div>
    </div>
  );
};

export default Register;