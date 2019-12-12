'use strict';

import React from 'react';
const ReactDOM = require('react-dom');
import axios from 'axios';

class App extends React.Component {
constructor() {
   super();
   this.state = {
      data: "",
      id:'',
      qty:''
   }
       this.handleSubmit = this.handleSubmit.bind(this);
       this.onChange = this.onChange.bind(this);
}

onChange = (e) => {
    this.setState({ [e.target.name]: e.target.value });
  }

handleSubmit(event) {
    event.preventDefault();
    axios.put(`${this.props.source}/${this.state.id}/${this.state.qty}`)
          .then(response => {
          	console.log(response)
          })
          .catch(error => {
              console.log(error.response)
          });
     this.setState({
      id: '',
      qty: ''
    });
  }



componentDidMount() {
 var th = this;
 this.serverRequest = axios.get(this.props.source)
 .then(function(event) {
     th.setState({
         data: event.data
     });
 })
}



componentWillUnmount() {
  this.serverRequest.abort();
}

render() {

if (!this.state.data) {
            return <div />
        }
 return (
    <div className="react">
      <div className="row">
         <div className="col-md-6 col-md-offset-5">
             <h1 className="title">Products Inventory</h1>
             <table>
             <thead>
              <tr>
                <th>Id</th>
                <th>Item</th>
                <th>Quantity</th>
              </tr>
              </thead>
              <tbody>
              {this.state.data.map(i => {
              return (
                   <tr>
                      <td>{i.id}</td>
                      <td>{i.item}</td>
                                        <td>{i.quantity}</td>
                                               </tr>
                                          )
                                      })}
              </tbody>
            </table>
         </div>
      </div>
        <br></br>
      <form onSubmit={this.handleSubmit}>
              <label>
                Id:
                <input type="text" name="id" value={this.state.id} onChange={this.onChange} />
              </label>
                <label>
                Quantity:
                <input type="text" name="qty" value={this.state.qty} onChange={this.onChange} />
              </label>
              <input type="submit" value="Order" />
            </form>
    </div>
  );
 }
}

ReactDOM.render(
   <App source="http://localhost:8080/products" />,
   document.getElementById('react')
);