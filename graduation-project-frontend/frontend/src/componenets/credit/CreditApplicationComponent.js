import React, { Component } from 'react';
import {Card, Form, Button, Row,Col,Table} from 'react-bootstrap';
import axios from 'axios'; 



class CreditApplicationComponent extends Component {

  constructor (props){
    super(props);
    this.state = this.initialState;
    this.customerChange = this.customerChange.bind(this);
    this.submitCustomer = this.submitCustomer.bind(this);   
    this.state = {   
      creditResultEnum :'',
      creditLimit : ''

    }   
  }
  initialState = {
    turkishIdentityNumber:'',
      name:'',
      middleName:'',
      surname:'',
      phoneNumber:'',
      email:'',
      dateOfBirth:'',
      monthlySalary:'',
      pledgeValue:''
  }

  initilizeResult = {
    creditLimit: '',
    creditResultEnum : ''
  }

  resetCustomer = () =>{

    this.setState(() => this.initialState);
    this.setState(() => this.initilizeResult);
  }

  submitCustomer = event =>{
      event.preventDefault();

      const customer = {
      turkishIdentityNumber : this.state.turkishIdentityNumber,
      name : this.state.name,
      middleName :this.state.middleName,
      surname: this.state.surname,
      email :  this.state.email,
      phoneNumber :  this.state.phoneNumber,
      dateOfBirth   :  this.state.dateOfBirth,
      monthlySalary  : this.state.monthlySalary,
      pledgeValue : this.state.pledgeValue

      };
/*
      axios.post("http://localhost:8080/api/credit-application/",customer).then(response =>{
          if(response.status === 200){
            this.setState(this.initialState);
            alert("Credit Application Saved Successfully");
          }
      }).catch(
          error => {
            alert("Something Went Wrong!\n\nMake Sure,Customer Already Saved,\nCustomer Salary Updated,\nHas No Credit Application,\nALL VALUES IN THE CORRECT FORM!");        
          }

      );*/
      axios.post("http://localhost:8080/api/credit-application/",customer)
      .then(response => response.data)
      .then((data) => {this.setState({creditResultEnum: data.creditResultEnum, creditLimit : data.creditLimit})})
      .catch(
        error => {
          alert("Something Went Wrong!\n\nMake Sure,Customer Already Saved,\nCustomer Salary Updated,\nHas No Credit Application,\nALL VALUES IN THE CORRECT FORM!");        
        }

    );
   
  }

  customerChange(event){
      this.setState({
          [event.target.name]:event.target.value
      })

  }

    render() {
      const {turkishIdentityNumber, name, middleName, surname, phoneNumber, email, dateOfBirth,  monthlySalary, pledgeValue      
      } = this.state;


        return (

          
          <Card className={"border border-dark bg-light text-white"}>
                  <Card.Header className='text-black'>APPLY FOR A CREDIT</Card.Header>
                  <Form onReset={this.resetCustomer} onSubmit={this.submitCustomer} id="customerFormId">
                  <Card.Body>
                   
                      <Row>
                        
                        <Form.Group as={Col} controlId="formGridName">
                              <Form.Label className='text-black'>Name</Form.Label>
                              <Form.Control required autoComplete='off'
                                  name = "name"
                                  type="text"
                                  value={name}
                                  onChange={this.customerChange} 
                                  placeholder="Enter Name" />                         
                        </Form.Group>
                        <Form.Group as={Col}  controlId="fromGridMiddleName">
                              <Form.Label className='text-black'>Middle Name</Form.Label>
                              <Form.Control  autoComplete='off'
                                  name="middleName"
                                  type="text"
                                  value={middleName}
                                  onChange={this.customerChange}                                   
                                  placeholder="Enter Middle Name If Has One" />                         
                        </Form.Group>
                        <Form.Group as={Col}  controlId="formGridSurname">
                              <Form.Label className='text-black'>Surname</Form.Label>
                              <Form.Control required autoComplete='off'
                                  name="surname"
                                  type="text"
                                  value={surname}
                                  onChange={this.customerChange} 
                                  placeholder="Enter Surname" />                         
                        </Form.Group>
                      </Row>   
                      <Row>
                      <Form.Group as={Col} controlId="formGridTurkishIdentityNumber">
                              <Form.Label className='text-black'>Turkish Identity Number</Form.Label>
                              <Form.Control required autoComplete='off'
                                  name = "turkishIdentityNumber"
                                  type="text"
                                  value={turkishIdentityNumber}
                                  onChange={this.customerChange} 
                                  placeholder="Enter Turkish Identity Number" />                         
                        </Form.Group>
                         <Form.Group as={Col}  controlId="formGridPhoneNumber">
                              <Form.Label className='text-black'>Phone Number | Should start with 0</Form.Label>
                              <Form.Control required autoComplete='off'
                                  name="phoneNumber"
                                  type="text"
                                  value={phoneNumber}
                                  onChange={this.customerChange} 
                                  placeholder="Enter Phone Number" />                         
                        </Form.Group>
                        <Form.Group as={Col}  controlId="fromGridEmail">
                              <Form.Label className='text-black'>Email</Form.Label>
                              <Form.Control required autoComplete='off'
                                  name="email"
                                  type="text"
                                  value={email}
                                  onChange={this.customerChange} 
                                  placeholder="Enter Email" />                         
                        </Form.Group>
                       
                      </Row>
                      <Row>
                      <Form.Group as={Col}  controlId="formGridDateOfBirth">
                              <Form.Label className='text-black'>Date Of Birth ( YYYY-MM-DD )</Form.Label>
                              <Form.Control required autoComplete='off'
                                  name="dateOfBirth"
                                  type="text"
                                  value={dateOfBirth}
                                  onChange={this.customerChange} 
                                  placeholder="YYYY-MM-DD" />                         
                        </Form.Group> 
                        <Form.Group as={Col}  controlId="formGridMonthlySalary">
                              <Form.Label className='text-black'>Monthly Salary</Form.Label>
                              <Form.Control required autoComplete='off'
                                  name="monthlySalary"
                                  type="text"
                                  value={monthlySalary}
                                  onChange={this.customerChange} 
                                  placeholder="Enter Monthly Salary" />                         
                        </Form.Group>
                        <Form.Group as={Col}  controlId="formGridPledgeValue">
                              <Form.Label className='text-black'>Pledge Value</Form.Label>
                              <Form.Control required autoComplete='off'
                                  name="pledgeValue"
                                  type="text"
                                  value={pledgeValue}
                                  onChange={this.customerChange} 
                                  placeholder="Enter Pledge Value"/>                         
                        </Form.Group>    
                      </Row>   
                                      


                  </Card.Body>  

                  <Card.Footer style={{"textAlign":"right"}}>

                        <Button size ="sm" class="btn btn-primary btn-lg button-space" variant="success" type="submit">
                            Submit
                        </Button>   
                                               
                        <Button  size ="sm"  variant="info" type="reset">
                           Reset
                        </Button>

                  </Card.Footer>
                  </Form>
                     
<Card.Header className='text-black'>Credit Application Result</Card.Header>
<Card.Body>
    <Table>
    <thead>
    <tr>      
      <th>Credit Result</th>
      <th>Credit Limit</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      
     
        <td>{this.state.creditResultEnum}</td>

      
     
      <td>{this.state.creditLimit}</td>    
    </tr>   
  </tbody>
    </Table>
</Card.Body>




          </Card>
        
        );
    }
}

export default CreditApplicationComponent;