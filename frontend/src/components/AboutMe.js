import React from "react";

function AboutMe() {
  return (
    <section id="About" className="m-3 p-5">
      <div className="mb-5">
        <h1 className="text-center h1">Prebeesh Surendran</h1>
        <hr />
        <p align="center" className="lead">
          Prebeesh, the mind behind this website, is a passionate Java backend developer with a dedication to building
          scalable, high-performance solutions for web applications. With a focus on clean, maintainable code,
          Prebeesh creates robust systems that drive seamless user experiences. A firm believer in continuous learning
          and improvement, he strives for excellence in every project.
        </p>
        <p align="center" className="lead">
          Prebeesh believes that innovation and creative problem-solving are key to success. By fostering
          collaboration and embracing new ideas, he empowers teams to work more effectively and achieve better
          outcomes. His unique approach combines technical expertise with a passion for continuous improvement,
          consistently delivering results that make a lasting impact.
        </p>
      </div>
      <div className="container-fluid p-2">
        <div className="row">
          <div className="col-lg-4">
            <img className="img-fluid rounded" src="/img/about-me.png" alt="About Me" />
          </div>
          <div className="col-lg-8">
            <h4 className="mt-1">Personal Details</h4>
            <dl className="row">
              <dt className="col-sm-3">Address</dt>
              <dd className="col-sm-9">478 Pearl Street, Burlington, ON, L7R 2N3, Canada.</dd>
              <dt className="col-sm-3">Email</dt>
              <dd className="col-sm-9">prebeesh.surendran@gmail.com</dd>
              <dt className="col-sm-3">Mobile Number</dt>
              <dd className="col-sm-9">(+1)437-869-7662</dd>
              <dt className="col-sm-3">Birthday</dt>
              <dd className="col-sm-9">26th November 1996</dd>
              <dt className="col-sm-3">Education</dt>
              <dd className="col-sm-9">Bachelors Degree in Computer Science and Engineering under Kerala University.<br />7.83 CGPA</dd>
              <dt className="col-sm-3">Public Profiles</dt>
              <dd className="col-sm-9">
                <ul className="list-inline mb-0">
                  <li className="list-inline-item"><a href="https://www.linkedin.com/in/prebeesh-s-581136153/" target="_blank" rel="noopener noreferrer"><i className="fab fa-linkedin fa-2x fa-fw"></i></a></li>
                  <li className="list-inline-item mr-3"><a href="https://stackoverflow.com/users/7288445/prebeesh" target="_blank" rel="noopener noreferrer"><i className="fab fa-stack-overflow fa-2x fa-fw"></i></a></li>
                  <li className="list-inline-item mr-3"><a href="https://github.com/Prebeesh" target="_blank" rel="noopener noreferrer"><i className="fab fa-github fa-2x fa-fw"></i></a></li>
                </ul>
              </dd>
            </dl>
          </div>
        </div>
        {/* Skills Section */}
        <section className="section m-2">
          <h3 className="text-center">Skills</h3>
          <div className="row p-3">
            <div className="col-lg-6 p-2">
              <div className="p-2">
                <h5>Core Java - 8, 11, 17 <i>(Oracle Certified Associate)</i></h5>
                <div className="progress" style={{height: 20}}>
                  <div className="progress-bar" role="progressbar" style={{width: "90%"}}>90%</div>
                </div>
              </div>
              <div className="p-2">
                <h5>Spring Boot &amp; Reactive Spring</h5>
                <div className="progress" style={{height: 20}}>
                  <div className="progress-bar" role="progressbar" style={{width: "85%"}}>85%</div>
                </div>
              </div>
              <div className="p-2">
                <h5>Microservices Architecture</h5>
                <div className="progress" style={{height: 20}}>
                  <div className="progress-bar" role="progressbar" style={{width: "80%"}}>80%</div>
                </div>
              </div>
              <div className="p-2">
                <h5>Apache Kafka</h5>
                <div className="progress" style={{height: 20}}>
                  <div className="progress-bar" role="progressbar" style={{width: "60%"}}>60%</div>
                </div>
              </div>
              <div className="p-2">
                <h5>AWS</h5>
                <div className="progress" style={{height: 20}}>
                  <div className="progress-bar" role="progressbar" style={{width: "60%"}}>60%</div>
                </div>
              </div>
            </div>
            <div className="col-lg-6 p-2">
              <div className="p-2">
                <h5>CI/CD <i>(Jenkins, Ansible, Git)</i></h5>
                <div className="progress" style={{height: 20}}>
                  <div className="progress-bar" role="progressbar" style={{width: "75%"}}>75%</div>
                </div>
              </div>
              <div className="p-2">
                <h5>Docker, Kubernetes &amp; Openshift</h5>
                <div className="progress" style={{height: 20}}>
                  <div className="progress-bar" role="progressbar" style={{width: "70%"}}>70%</div>
                </div>
              </div>
              <div className="p-2">
                <h5>RESTful API Development</h5>
                <div className="progress" style={{height: 20}}>
                  <div className="progress-bar" role="progressbar" style={{width: "80%"}}>80%</div>
                </div>
              </div>
              <div className="p-2">
                <h5>SQL</h5>
                <div className="progress" style={{height: 20}}>
                  <div className="progress-bar" role="progressbar" style={{width: "80%"}}>80%</div>
                </div>
              </div>
              <div className="p-2">
                <h5>UI - HTML, CSS, JS, JQuery, React</h5>
                <div className="progress" style={{height: 20}}>
                  <div className="progress-bar" role="progressbar" style={{width: "30%"}}>30%</div>
                </div>
              </div>
            </div>
          </div>
        </section>
        {/* End Skills Section */}
      </div>
    </section>
  );
}

export default AboutMe; 