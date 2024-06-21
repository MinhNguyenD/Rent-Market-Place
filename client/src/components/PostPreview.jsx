const PostPreview = ({ post, handleDelete }) => {
    return (
    <>
      <div className="row row-cols-1 row-cols-md-2 row-cols-lg-3 g-4">
          <div className="col"></div>
            <div className="card" key={post._id}>
              <img src="././public/sk-icon.png" className="card-img-top" />
              <div className="card-body">
                <h5 className="card-title">{post.title}</h5>
                <p className="card-text">
                  Description: {post.description}
                  NumBed: {post.numBed}
                </p>
                <a href="#" className="btn btn-primary">
                  View
                </a>
              </div>
      </div>
      </div>
    </>
    )
}
export default PostPreview
