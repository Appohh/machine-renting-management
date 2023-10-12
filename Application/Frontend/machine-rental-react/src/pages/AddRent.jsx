import { useState } from 'react'


function AddRent() {

    const [formData, setFormData] = useState({
        productId: '',
        customerId: '',
        start: '',
        end: '',
        address: '',
        city: '',
        total: '',
        discount: '',
        paid: '',
    });

    const handleChange = (e) => {
        const { name, value } = e.target;
        setFormData({
            ...formData,
            [name]: value,
        });
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        console.log('Form data submitted:', formData);
        // Add your submission logic here
    };

    return (
        <>
            <h1>Add rent</h1>
            <form className='form' onSubmit={handleSubmit}>
                <input placeholder='Product' type="text" name="productId" value={formData.productId} onChange={handleChange} />
                <input placeholder='Customer' type="text" name="customerId" value={formData.customerId} onChange={handleChange} />
                <input placeholder='From' type="date" name="start" value={formData.start} onChange={handleChange} />
                <input placeholder='Until' type="date" name="end" value={formData.end} onChange={handleChange} />
                <input placeholder='Address' type="text" name="address" value={formData.address} onChange={handleChange} />
                <input placeholder='City' type="text" name="city" value={formData.city} onChange={handleChange} />
                <input placeholder='Total' type="text" name="total" value={formData.total} onChange={handleChange} />
                <input placeholder='Discount' type="text" name="discount" value={formData.discount} onChange={handleChange} />
                <input placeholder='Paid' type="text" name="paid" value={formData.paid} onChange={handleChange} />
                <button type="submit">Submit</button>
            </form>
        </>
    )
}

export default AddRent
