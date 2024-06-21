import Header from "../components/Header"

const CreatePost = () => {
    return (
    <>
        <Header/>
        <div class="container">
            <h2>Create Listing</h2>
            <form>
                <div class="form-group">
                    <label for="num_bed_room">Number of Bedrooms:</label>
                    <input type="number" class="form-control" id="num_bed_room" name="num_bed_room" required/>
                </div>
                <div class="form-group">
                    <label for="num_bath_room">Number of Bathrooms:</label>
                    <input type="number" class="form-control" id="num_bath_room" name="num_bath_room" required/>
                </div>
                <div class="form-group">
                    <label for="num_bed">Number of Beds:</label>
                    <input type="number" class="form-control" id="num_bed" name="num_bed" required/>
                </div>
                <div class="form-group">
                    <label for="room_description">Room Description:</label>
                    <textarea class="form-control" id="room_description" name="room_description" rows="3" required></textarea>
                </div>
                <div class="form-group">
                    <label for="location_id">Location ID:</label>
                    <input type="number" class="form-control" id="location_id" name="location_id" required/>
                </div>
                <div class="form-group">
                    <label for="cost_per_day">Cost per Day ($):</label>
                    <input type="number" class="form-control" id="cost_per_day" name="cost_per_day" step="0.01" required/>
                </div>
                <div class="form-group">
                    <label for="picture">Picture URL:</label>
                    <input type="text" class="form-control" id="picture" name="picture" required/>
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
    </>
    )
}
export default CreatePost
