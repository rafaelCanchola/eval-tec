import React, {useState} from 'react';
import './App.css';
import "tailwindcss/dist/base.css";
import "./styles/globalStyles.css";
import { css } from "styled-components/macro"; //eslint-disable-line
import Header, {LogoLink, NavLink, NavLinks, PrimaryLink} from "./components/headers/light.js";
import AnimationRevealPage from "./components/helpers/AnimationRevealPage";
import tw from "twin.macro";
import styled from "styled-components";

import imagenFondo from "./images/person.svg"

import Table from "./pages/Table";
import {render} from "react-dom";

const Container = tw.div`relative -mx-8 -mt-8`;
const TwoColumn = tw.div`flex flex-col lg:flex-row bg-gray-100`;
const LeftColumn = tw.div`ml-6 mr-6 xl:pl-6 py-6 `;
const RightColumn = styled.div`
  background-image: url(${imagenFondo});
  ${tw`bg-teal-500 bg-cover bg-center xl:ml-24 h-96 lg:h-auto lg:w-1/2 lg:flex-1`}
  `;

const Content = tw.div`mt-24 lg:mt-24 lg:mb-24 flex flex-col sm:items-center lg:items-center`;
const Heading = tw.h1`text-3xl sm:text-5xl md:text-6xl lg:text-5xl font-black leading-none`;
const Paragraph = tw.p`max-w-md my-8 lg:my-5 lg:my-8 sm:text-lg lg:text-base xl:text-lg leading-loose`;
const Separator = tw.div` items-center p-3`;
const Styles = styled.div`
  padding: 1rem;

  table {
    border-spacing: 0;
    border: 1px solid black;

    tr {
      :last-child {
        td {
          border-bottom: 0;
        }
      }
    }

    th,
    td {
      margin: 0;
      padding: 0.5rem;
      border-bottom: 1px solid black;
      border-right: 1px solid black;

      :last-child {
        border-right: 0;
      }
    }
  }

  .pagination {
    padding: 0.5rem;
  }
`
const heading = (
        <>
            Evaluación Técnica
            <wbr />
            <br />
            <span tw="text-teal-500">José Rafael <br/>Canchola Angeles</span>
        </>
);
const StyledHeader = styled(Header)`
  ${tw`justify-between`}
  ${LogoLink} {
    ${tw`mr-8 pb-0`}
  }
`;

function App() {
    const [selectedFile, setSelectedFile] = useState();
    const [resultOne = [{folio:1,fecha:1,usuario:{usuario:{nombre:""}}}], setResultOne] = useState();
    const [selectedResult, setSelectedResult] = useState();
    const changeHandler = (event:any) => {
        setSelectedFile(event.target.files[0]);
    };

    const handleSubmission = () => {
        const formData = new FormData();
        // @ts-ignore
        formData.append('file', selectedFile);

        fetch(
            'http://localhost:8080/api/cargar',
            {
                method: 'POST',
                body: formData,
                headers: {"Access-Control-Allow-Origin": "*"},
            }
        )
            .then((response) => response.json())
            .then((result) => {
                console.log('Success:', result);
            })
            .catch((error) => {
                console.error('Error:', error);
            });
    };

    const defaultLinks = [
        <NavLinks key={1}>
            <NavLink href="/#ej1">Ver Ejercicios</NavLink>
            <NavLink href="/#">Ver Modelo E/R</NavLink>
            <NavLink href="/#"><input type="file" name="file" onChange={changeHandler}/></NavLink>
            <PrimaryLink href="/#" onClick={handleSubmission}>Subir CSV</PrimaryLink>
        </NavLinks>
    ];

    const header1 =
        React.useMemo(
        () => [
            {
                Header: 'Contratos de Pemex Transformación Industrial',
                columns: [
                    {
                        Header: 'Contrato',
                        accessor: 'folio',
                    },
                    {
                        Header: 'Fecha',
                        accessor: 'fecha',
                    },
                    {
                        Header: 'ID Nodo de Entrega',
                        accessor: 'usuario.entrega.id',
                    },
                    {
                        Header: 'Nodo de Entrega',
                        accessor: 'usuario.entrega.nombre',
                    },
                    {
                        Header: 'ID Nodo de Recepción',
                        accessor: 'usuario.recepcion.id',
                    },
                    {
                        Header: 'Nodo de Recepción',
                        accessor: 'usuario.recepcion.nombre',
                    },
                ],
            },
        ],[])

    const header2 = React.useMemo(
        () => [
            {
                Header: 'Usuario asociado al contrato CENAGAS/A/200/19',
                columns: [
                    {
                        Header: 'Usuario',
                        accessor: 'usuario.usuario.nombre',
                    },

                ],
            },
        ],[])

    const header3 = React.useMemo(
        () => [
            {
                Header: 'Usuarios del Nodo V033 como Nodo de Recepción de Gas Natural',
                columns: [
                    {
                        Header: 'Usuario',
                        accessor: 'nombre',
                    },
                ],
            },
        ],[])

    const header4 =
        React.useMemo(
            () => [
                {
                    Header: 'Contratos de Nodos Comerciales N103, N046 y E168',
                    columns: [
                        {
                            Header: 'Contrato',
                            accessor: 'folio',
                        },
                        {
                            Header: 'Fecha',
                            accessor: 'fecha',
                        },
                        {
                            Header: 'Usuario',
                            accessor: 'usuario.usuario.nombre',
                        },
                        {
                            Header: 'ID Nodo de Entrega',
                            accessor: 'usuario.entrega.id',
                        },
                        {
                            Header: 'Nodo de Entrega',
                            accessor: 'usuario.entrega.nombre',
                        },
                        {
                            Header: 'ID Nodo de Recepción',
                            accessor: 'usuario.recepcion.id',
                        },
                        {
                            Header: 'Nodo de Recepción',
                            accessor: 'usuario.recepcion.nombre',
                        },
                    ],
                },
            ],[])

    const header5 = React.useMemo(
        () => [
            {
                Header: 'Nodos de Recepción',
                columns: [
                    {
                        Header: 'Nombre',
                        accessor: 'nombre',
                    },
                    {
                        Header: 'ID',
                        accessor: 'id',
                    },
                    {
                        Header: 'Zona',
                        accessor: 'zonatarifa',
                    },
                ],
            },
        ],[])

    const header6 = React.useMemo(
        () => [
            {
                Header: 'Nodos de Entrega',
                columns: [
                    {
                        Header: 'Nombre',
                        accessor: 'nombre',
                    },
                    {
                        Header: 'ID',
                        accessor: 'id',
                    },
                    {
                        Header: 'Zona',
                        accessor: 'zonatarifa',
                    },
                ],
            },
        ],[])

    const header7 = React.useMemo(
        () => [
            {
                Header: 'Usuarios con nodos de inyección en Zona 3',
                columns: [
                    {
                        Header: 'Nombre',
                        accessor: 'usuario.nombre',
                    },
                    {
                        Header: 'ID Nodo Recepción',
                        accessor: 'recepcion.id',
                    },
                    {
                        Header: 'Nodo Recepción',
                        accessor: 'recepcion.nombre',
                    },
                ],
            },
        ],[])

    const header8 = React.useMemo(
        () => [
            {
                Header: 'Usuarios con nodos de extracción en Zona 2,5 y 6',
                columns: [
                    {
                        Header: 'Nombre',
                        accessor: 'usuario.nombre',
                    },
                    {
                        Header: 'ID Nodo Recepción',
                        accessor: 'entrega.id',
                    },
                    {
                        Header: 'Nodo Recepción',
                        accessor: 'entrega.nombre',
                    },
                    {
                        Header: 'Nodo Recepción',
                        accessor: 'entrega.zonatarifa',
                    },
                ],
            },
        ],[])

    const header9 = React.useMemo(
        () => [
            {
                Header: 'Usuarios con contratos CENAGAS/A/100/17, CENAGAS/A/500/17, CENAGAS/B/800/17 y CENAGAS/B/200/18',
                columns: [
                    {
                        Header: 'Nombre',
                        accessor: 'usuario.nombre',
                    },
                ],
            },
        ],[])

    const header10 = React.useMemo(
        () => [
            {
                Header: 'Nodos de Recepción y Entrega del Usuario Enestas',
                columns: [
                    {
                        Header: 'Nombre',
                        accessor: 'usuario.nombre',
                    },
                    {
                        Header: 'ID Nodo de Entrega',
                        accessor: 'entrega.id',
                    },
                    {
                        Header: 'Nodo de Entrega',
                        accessor: 'entrega.nombre',
                    },
                    {
                        Header: 'ID Nodo de Recepción',
                        accessor: 'recepcion.id',
                    },
                    {
                        Header: 'Nodo de Recepción',
                        accessor: 'recepcion.nombre',
                    },
                ],
            },
        ],[])

    const headerOnce = React.useMemo(
        () => [
            {
                Header: 'Contrato y usuario que utiliza el Nodo Comercial de Recepción V033 y Nodo Comercial de Entrega E076',
                columns: [
                    {
                        Header: 'Nombre',
                        accessor: 'usuario.usuario.nombre',
                    },
                    {
                        Header: 'Contrato',
                        accessor: 'folio',
                    },
                    {
                        Header: 'Fecha',
                        accessor: 'fecha',
                    },

                ],
            },
        ],[])

    const header12 = React.useMemo(
        () => [
            {
                Header: 'Total a Facturar el 28/03/21 contrato CENAGAS/B/800/18',
                columns: [
                    {
                        Header: 'Nombre',
                        accessor: 'usuario.usuario.nombre',
                    },
                    {
                        Header: 'Total a Facturar',
                        accessor: 'total',
                    },

                ],
            },
        ],[])

    const header13 = React.useMemo(
        () => [
            {
                Header: 'Total a facturar Enero 2021',
                columns: [
                    {
                        Header: 'Nombre',
                        accessor: 'usuario.usuario.nombre',
                    },
                    {
                        Header: 'Total a Facturar',
                        accessor: 'total',
                    },

                ],
            },
        ],[])

    const header14 = React.useMemo(
        () => [
            {
                Header: 'Promedio de Total a facturar Enero 2021 CFE',
                columns: [
                    {
                        Header: 'Promedio',
                        accessor: 'c_nom_rec',
                    },

                ],
            },
        ],[])

    const header15 = React.useMemo(
        () => [
            {
                Header: 'Cantidad Nominada Recepción 0 ',
                columns: [
                    {
                        Header: 'Nombre',
                        accessor: 'usuario.usuario.nombre',
                    },
                    {
                        Header: 'Total a Facturar',
                        accessor: 'total',
                    },
                    {
                        Header: 'Cant. Asig. Entrega',
                        accessor: 'c_asi_ent',
                    },
                    {
                        Header: 'Cant. Asig. Recepción',
                        accessor: 'c_asi_rec',
                    },
                    {
                        Header: 'Cant. Nomi. Entrega',
                        accessor: 'c_nom_ent',
                    },
                    {
                        Header: 'Cant. Nomi. Rec',
                        accessor: 'c_nom_rec',
                    },
                    {
                        Header: 'Cargo Exceso',
                        accessor: 'cargo_exceso',
                    },
                    {
                        Header: 'Cargo Uso ',
                        accessor: 'cargo_uso',
                    },
                    {
                        Header: 'Folio',
                        accessor: 'folio',
                    },
                    {
                        Header: 'Fecha',
                        accessor: 'fecha',
                    },
                    {
                        Header: 'Nodo Entrega',
                        accessor: 'usuario.entrega.id',
                    },
                    {
                        Header: 'Nodo Recepción',
                        accessor: 'usuario.recepcion.id',
                    },

                ],
            },
        ],[])

    const header16 = React.useMemo(
        () => [
            {
                Header: 'Cantidad Asignada Entrega < 2000 ',
                columns: [
                    {
                        Header: 'Nombre',
                        accessor: 'usuario.usuario.nombre',
                    },
                    {
                        Header: 'Total a Facturar',
                        accessor: 'total',
                    },
                    {
                        Header: 'Cant. Asig. Entrega',
                        accessor: 'c_asi_ent',
                    },
                    {
                        Header: 'Cant. Asig. Recepción',
                        accessor: 'c_asi_rec',
                    },
                    {
                        Header: 'Cant. Nomi. Entrega',
                        accessor: 'c_nom_ent',
                    },
                    {
                        Header: 'Cant. Nomi. Recepción',
                        accessor: 'c_nom_rec',
                    },
                    {
                        Header: 'Cargo Exceso',
                        accessor: 'cargo_exceso',
                    },
                    {
                        Header: 'Cargo Uso ',
                        accessor: 'cargo_uso',
                    },
                    {
                        Header: 'Folio',
                        accessor: 'folio',
                    },
                    {
                        Header: 'Fecha',
                        accessor: 'fecha',
                    },
                    {
                        Header: 'Nodo Entrega',
                        accessor: 'usuario.entrega.id',
                    },
                    {
                        Header: 'Nodo Recepción',
                        accessor: 'usuario.recepcion.id',
                    },

                ],
            },
        ],[])

    //@ts-ignore
    const EjercicioUno = (nombre,ejercicio) =>{
        setSelectedResult(ejercicio)
        fetch(
            'http://localhost:8080/api/ejercicioUno?&nombre='+nombre+'&ejercicio='+ejercicio,
            {
                method: 'GET',
                headers: {"Access-Control-Allow-Origin": "*"},
            }
        ).then(response => response.json())
            .then((result) => {
                console.log('Success:', result);
                setResultOne(result)
            })
            .catch((error) => {
                console.error('Error:', error);
            });
    }

    //@ts-ignore
    const EjercicioTres = (nombre,ejercicio) =>{
        setSelectedResult(ejercicio)
        fetch(
            'http://localhost:8080/api/ejercicioTres?&nombre='+nombre+'&ejercicio='+ejercicio,
            {
                method: 'GET',
                headers: {"Access-Control-Allow-Origin": "*"},
            }
        ).then(response => response.json())
            .then((result) => {
                console.log('Success:', result);
                setResultOne(result)
            })
            .catch((error) => {
                console.error('Error:', error);
            });
    }

    //@ts-ignore
    const EjercicioCinco = (nombre,ejercicio) =>{
        setSelectedResult(ejercicio)
        fetch(
            'http://localhost:8080/api/ejercicioCinco?&nombre='+nombre+'&ejercicio='+ejercicio,
            {
                method: 'GET',
                headers: {"Access-Control-Allow-Origin": "*"},
            }
        ).then(response => response.json())
            .then((result) => {
                console.log('Success:', result);
                setResultOne(result)
            })
            .catch((error) => {
                console.error('Error:', error);
            });
    }

    //@ts-ignore
    const EjercicioSiete = (nombre,ejercicio) =>{
        setSelectedResult(ejercicio)
        fetch(
            'http://localhost:8080/api/ejercicioSiete?&nombre='+nombre+'&ejercicio='+ejercicio,
            {
                method: 'GET',
                headers: {"Access-Control-Allow-Origin": "*"},
            }
        ).then(response => response.json())
            .then((result) => {
                console.log('Success:', result);
                setResultOne(result)
            })
            .catch((error) => {
                console.error('Error:', error);
            });
    }
    return (
    <div className="App">
        <AnimationRevealPage>
            <Container>
                <TwoColumn>
                    <LeftColumn>
                        <StyledHeader links={defaultLinks} collapseBreakpointClass="sm" className={""} logoLink={undefined} />
                        <Content>
                            <Heading>{heading}</Heading>
                            <Paragraph>En las secciones que a continuación se muestran se han diseñado las tablas las cuales contienen la información para cada punto</Paragraph>
                        </Content>
                    </LeftColumn>
                    <RightColumn/>
                </TwoColumn>
            </Container>
            <div id="ej1">
                <Container>
                    <Content>
                        <Separator>
                            <PrimaryLink href="/#ej1" onClick={ () => EjercicioUno("Pemex Transformación Industrial",1)} >Cargar Ejercicio 1</PrimaryLink>
                            <PrimaryLink href="/#ej1" onClick={ () => EjercicioUno("CENAGAS/A/200/19",2)} >Cargar Ejercicio 2</PrimaryLink>
                            <PrimaryLink href="/#ej1" onClick={ () => EjercicioTres("V033",3)} >Cargar Ejercicio 3</PrimaryLink>
                            <PrimaryLink href="/#ej1" onClick={ () => EjercicioUno("",4)} >Cargar Ejercicio 4</PrimaryLink>
                            <PrimaryLink href="/#ej1" onClick={ () => EjercicioCinco("",5)} >Cargar Ejercicio 5</PrimaryLink>
                        </Separator>
                        <Separator>
                            <PrimaryLink href="/#ej1" onClick={ () => EjercicioCinco("",6)} >Cargar Ejercicio 6</PrimaryLink>
                            <PrimaryLink href="/#ej1" onClick={ () => EjercicioSiete("Zona 3",7)} >Cargar Ejercicio 7</PrimaryLink>
                            <PrimaryLink href="/#ej1" onClick={ () => EjercicioSiete("",8)} >Cargar Ejercicio 8</PrimaryLink>
                            <PrimaryLink href="/#ej1" onClick={ () => EjercicioSiete("",9)} >Cargar Ejercicio 9</PrimaryLink>
                            <PrimaryLink href="/#ej1" onClick={ () => EjercicioSiete("Enestas",10)} >Cargar Ejercicio 10</PrimaryLink>
                        </Separator>
                        <Separator>
                            <PrimaryLink href="/#ej1" onClick={ () => EjercicioUno("",11)} >Cargar Ejercicio 11</PrimaryLink>
                            <PrimaryLink href="/#ej1" onClick={ () => EjercicioUno("",12)} >Cargar Ejercicio 12</PrimaryLink>
                            <PrimaryLink href="/#ej1" onClick={ () => EjercicioUno("",13)} >Cargar Ejercicio 13</PrimaryLink>
                            <PrimaryLink href="/#ej1" onClick={ () => EjercicioUno("",14)} >Cargar Ejercicio 14</PrimaryLink>
                            <PrimaryLink href="/#ej1" onClick={ () => EjercicioUno("",15)} >Cargar Ejercicio 15</PrimaryLink>
                        </Separator>
                        <Separator>
                            <PrimaryLink href="/#ej1" onClick={ () => EjercicioUno("",16)} >Cargar Ejercicio 16</PrimaryLink>
                            <PrimaryLink href="/#ej1" onClick={ () => EjercicioCinco("",17)} >Cargar Ejercicio 17</PrimaryLink>
                            <PrimaryLink href="/#ej1" onClick={ () => EjercicioCinco("",18)} >Cargar Ejercicio 18</PrimaryLink>
                            <PrimaryLink href="/#ej1" onClick={ () => EjercicioCinco("",19)} >Cargar Ejercicio 19</PrimaryLink>
                            <PrimaryLink href="/#ej1" onClick={ () => EjercicioCinco("",20)} >Cargar Ejercicio 20</PrimaryLink>
                        </Separator>
                            <Styles>
                            {!resultOne[0] ? <></>:
                                resultOne[0].fecha === 1 ?<></> :
                                    selectedResult === 1 ? <Table columns={header1} data={resultOne}/>:
                                        selectedResult === 2 ? <Table columns={header2} data={resultOne}/>:
                                            selectedResult === 3 ? <Table columns={header3} data={resultOne}/>:
                                                selectedResult === 4 ? <Table columns={header4} data={resultOne}/>:
                                                    selectedResult === 5 ? <Table columns={header5} data={resultOne}/>:
                                                        selectedResult === 6 ? <Table columns={header6} data={resultOne}/>:
                                                            selectedResult === 7 ? <Table columns={header7} data={resultOne}/>:
                                                                selectedResult === 8 ? <Table columns={header8} data={resultOne}/>:
                                                                    selectedResult === 9 ? <Table columns={header9} data={resultOne}/>:
                                                                        selectedResult === 10 ? <Table columns={header10} data={resultOne}/>:
                                                                            selectedResult === 11 ? <Table columns={headerOnce} data={resultOne}/>:
                                                                                selectedResult === 12 ? <Table columns={header12} data={resultOne}/>:
                                                                                    selectedResult === 13 ? <Table columns={header13} data={resultOne}/>:
                                                                                        selectedResult === 14 ? <Table columns={header14} data={resultOne}/>:
                                                                                            selectedResult === 15 ? <Table columns={header15} data={resultOne}/>:
                                                                                                selectedResult === 16 ? <Table columns={header16} data={resultOne}/>:
                                                                                                    selectedResult === 17 ? <Table columns={header13} data={resultOne}/>:
                                                                                                        selectedResult === 18 ? <Table columns={header13} data={resultOne}/>:
                                                                                                            selectedResult === 19 ? <Table columns={header13} data={resultOne}/>:
                                                                                                                <Table columns={header1} data={resultOne}/>
                            }
                        </Styles>
                    </Content>
                </Container>
            </div>
        </AnimationRevealPage>
    </div>
  );
}

export default App;
