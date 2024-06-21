const Post = () => {
    return (
        <>
        <div class="container">
            <h2>Room Details</h2>
            <div class="row">
                <div class="col-md-6">
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title">Room Information</h5>
                            <ul class="list-group list-group-flush">
                                <li class="list-group-item"><strong>Number of Bedrooms:</strong> <span id="num_bed_room"></span></li>
                                <li class="list-group-item"><strong>Number of Bathrooms:</strong> <span id="num_bath_room"></span></li>
                                <li class="list-group-item"><strong>Number of Beds:</strong> <span id="num_bed"></span></li>
                                <li class="list-group-item"><strong>Room Description:</strong> <span id="room_description"></span></li>
                                <li class="list-group-item"><strong>Location ID:</strong> <span id="location_id"></span></li>
                                <li class="list-group-item"><strong>Cost per Day ($):</strong> <span id="cost_per_day"></span></li>
                                <li class="list-group-item"><strong>Picture:</strong> <img src="" id="picture" alt="Room Picture"/></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        </>
    )
}
export default Post
