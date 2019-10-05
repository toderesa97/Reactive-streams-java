In this example we have a ``Sensor`` that submits data into
a ``Subscriber`` which is a ``Computer``.

A ``Publisher`` serves for producing or publishing items and control signals.
In this example we are using the class ``SubmissionPublisher`` which is the only one
implementing class of the ``Publisher<T>`` and it is a producer of items to submit and 
pass the submitted data to the next in the chain, that happens to be a ``Subscriber``.

Once ``submit`` method is called, ``onNext(T item)`` is invoked on the ``Subscriber``. When the data flow
reaches the end, ``onComplete()`` method is called.

Note that in this example an ``IdleSleeper`` is being used to simulate the asynchronous reception of data to the stream.

![graph](https://user-images.githubusercontent.com/19231158/66255020-9e546900-e776-11e9-85fc-e4154aa6d104.png)


In the next exercise we are:

- Fetching data from a public API (jsonPlaceHolder site) thus implementing our own ``Publisher<T>``
- Using the ``TranformProcessor<T, R>`` to actually deal with data.


