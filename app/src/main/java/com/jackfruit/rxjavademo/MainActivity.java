package com.jackfruit.rxjavademo;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.concurrent.TimeUnit;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

  private static final String TAG = "MainActivity";
  private TextView mSkipTest;
  private TextView mDebounceTest;
  private TextView mDistinctTest;
  private TextView mElementAtTest;
  private TextView mFilterTest;
  private TextView mFirstTest;
  private TextView mLastTest;
  private TextView mIgnoreElementTest;
  private TextView mOfTypeTest;
  private TextView mSampleTest;
  private TextView mThrottleFirstTest;
  private TextView mThrottleLatestTest;
  private TextView mTakeAndtakeLastTest;
  private TextView mTimeoutTest;
  private TextView mStartWithTest;
  private TextView mMergeTest;
  private TextView mZipTest;
  private TextView mBufferTest;
  private TextView mCastTest;
  private TextView mConcatMapTest;
  private TextView mConcatMapDelayErrorTest;
  private TextView mConcatMapCompletableTest;
  private TextView mConcatMapCompletableDelayErrorTest;
  private TextView mFlatMapTest;
  private TextView mFlattenAsFlowableAndFlattenAsObservableTest;
  private TextView mGroupByTest;
  private TextView mScanTest;
  private TextView mWindowTest;
  private TextView mOnErrorReturnTest;
  private TextView mOnErrorReturnItemTest;
  private TextView mOnExceptionResumeNextTest;
  private TextView mRetryTest;
  private TextView mRetryUntilTest;

  @RequiresApi(api = Build.VERSION_CODES.N)
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    initView();
    // 对数据源过滤操作符
    // skipTest();
    // debounceTest();
    // distinctTest();
    // elementAtTest();
    // filterTest();
    // firstTest();
    // lastTest();
    // ignoreElementTest();
    // ofTypeTest();
    // sampleTest();
    // throttleFirstTest();
    // throttleLatestTest();
    // takeAndtakeLastTest();
    // timeoutTest();
    // 操作符:连接操作符，通过连接操作符，将多个被观察数据（数据源）连接在一起。
    // startWithTest();
    // mergeTest();
    // zipTest();
    // 变换操作符,变化数据源的数据，并转化为新的数据源。
    // bufferTest();
    // castTest();
    // concatMapTest();
    // concatMapDelayErrorTest();
    // concatMapCompletableTest();
    // concatMapCompletableDelayErrorTest();
    // flatMapTest();
    // flattenAsFlowableAndFlattenAsObservableTest();
    // groupByTest();
    // scanTest();
    // windowTest();
    // 错误处理操作符
    // onErrorReturnTest();
    // onErrorReturnItemTest();
    // onExceptionResumeNextTest();
    // retryTest();
    // retryUntilTest();
  }

  private void initView() {
    mSkipTest = (TextView) findViewById(R.id.skipTest);
    mSkipTest.setOnClickListener(this);
    mDebounceTest = (TextView) findViewById(R.id.debounceTest);
    mDebounceTest.setOnClickListener(this);
    mDistinctTest = (TextView) findViewById(R.id.distinctTest);
    mDistinctTest.setOnClickListener(this);
    mElementAtTest = (TextView) findViewById(R.id.elementAtTest);
    mElementAtTest.setOnClickListener(this);
    mFilterTest = (TextView) findViewById(R.id.filterTest);
    mFilterTest.setOnClickListener(this);
    mFirstTest = (TextView) findViewById(R.id.firstTest);
    mFirstTest.setOnClickListener(this);
    mLastTest = (TextView) findViewById(R.id.lastTest);
    mLastTest.setOnClickListener(this);
    mIgnoreElementTest = (TextView) findViewById(R.id.ignoreElementTest);
    mIgnoreElementTest.setOnClickListener(this);
    mOfTypeTest = (TextView) findViewById(R.id.ofTypeTest);
    mOfTypeTest.setOnClickListener(this);
    mSampleTest = (TextView) findViewById(R.id.sampleTest);
    mSampleTest.setOnClickListener(this);
    mThrottleFirstTest = (TextView) findViewById(R.id.throttleFirstTest);
    mThrottleFirstTest.setOnClickListener(this);
    mThrottleLatestTest = (TextView) findViewById(R.id.throttleLatestTest);
    mThrottleLatestTest.setOnClickListener(this);
    mTakeAndtakeLastTest = (TextView) findViewById(R.id.takeAndtakeLastTest);
    mTakeAndtakeLastTest.setOnClickListener(this);
    mTimeoutTest = (TextView) findViewById(R.id.timeoutTest);
    mTimeoutTest.setOnClickListener(this);
    mStartWithTest = (TextView) findViewById(R.id.startWithTest);
    mStartWithTest.setOnClickListener(this);
    mMergeTest = (TextView) findViewById(R.id.mergeTest);
    mMergeTest.setOnClickListener(this);
    mZipTest = (TextView) findViewById(R.id.zipTest);
    mZipTest.setOnClickListener(this);
    mBufferTest = (TextView) findViewById(R.id.bufferTest);
    mBufferTest.setOnClickListener(this);
    mCastTest = (TextView) findViewById(R.id.castTest);
    mCastTest.setOnClickListener(this);
    mConcatMapTest = (TextView) findViewById(R.id.concatMapTest);
    mConcatMapTest.setOnClickListener(this);
    mConcatMapDelayErrorTest = (TextView) findViewById(R.id.concatMapDelayErrorTest);
    mConcatMapDelayErrorTest.setOnClickListener(this);
    mConcatMapCompletableTest = (TextView) findViewById(R.id.concatMapCompletableTest);
    mConcatMapCompletableTest.setOnClickListener(this);
    mConcatMapCompletableDelayErrorTest =
        (TextView) findViewById(R.id.concatMapCompletableDelayErrorTest);
    mConcatMapCompletableDelayErrorTest.setOnClickListener(this);
    mFlatMapTest = (TextView) findViewById(R.id.flatMapTest);
    mFlatMapTest.setOnClickListener(this);
    mFlattenAsFlowableAndFlattenAsObservableTest =
        (TextView) findViewById(R.id.flattenAsFlowableAndFlattenAsObservableTest);
    mFlattenAsFlowableAndFlattenAsObservableTest.setOnClickListener(this);
    mGroupByTest = (TextView) findViewById(R.id.groupByTest);
    mGroupByTest.setOnClickListener(this);
    mScanTest = (TextView) findViewById(R.id.scanTest);
    mScanTest.setOnClickListener(this);
    mWindowTest = (TextView) findViewById(R.id.windowTest);
    mWindowTest.setOnClickListener(this);
    mOnErrorReturnTest = (TextView) findViewById(R.id.onErrorReturnTest);
    mOnErrorReturnTest.setOnClickListener(this);
    mOnErrorReturnItemTest = (TextView) findViewById(R.id.onErrorReturnItemTest);
    mOnErrorReturnItemTest.setOnClickListener(this);
    mOnExceptionResumeNextTest = (TextView) findViewById(R.id.onExceptionResumeNextTest);
    mOnExceptionResumeNextTest.setOnClickListener(this);
    mRetryTest = (TextView) findViewById(R.id.retryTest);
    mRetryTest.setOnClickListener(this);
    mRetryUntilTest = (TextView) findViewById(R.id.retryUntilTest);
    mRetryUntilTest.setOnClickListener(this);
  }

  @Override
  public void onClick(View v) {
    switch (v.getId()) {
      case R.id.skipTest:
        // skip（跳过）
        // 可以作用于Flowable,Observable，表示源发射数据前，跳过多少个。例如下面跳过前四个：
        skipTest();
        break;
      case R.id.debounceTest:
        // debounce（去抖动）
        // 可作用于Flowable,Observable。在Android开发，通常为了防止用户重复点击而设置标记位，而通过RxJava的debounce操作符可以有效达到该效果。
        // 在规定时间内，用户重复点击只有最后一次有效，
        debounceTest();
        break;
      case R.id.distinctTest:
        // distinct（去重）
        // 可作用于Flowable,Observable，去掉数据源重复的数据。
        distinctTest();
        break;
      case R.id.elementAtTest:
        // elementAt（获取指定位置元素）
        // 可作用于Flowable,Observable，从数据源获取指定位置的元素，从0开始。
        elementAtTest();
        break;
      case R.id.filterTest:
        // filter（过滤）
        // 可作用于 Flowable,Observable,Maybe,Single。在filter中返回表示发射该元素，返回false表示过滤该数据。
        filterTest();
        break;
      case R.id.firstTest:
        // first(第一个)
        // 作用于 Flowable,Observable。发射数据源第一个数据，如果没有则发送默认值。
        firstTest();
        break;
      case R.id.lastTest:
        // last(最后一个)
        // last、lastElement、lastOrError与fist、firstElement、firstOrError相对应。
        lastTest();
        break;
      case R.id.ignoreElementTest:
        // ignoreElements & ignoreElement（忽略元素）
        // ignoreElements 作用于Flowable、Observable。ignoreElement作用于Maybe、Single。两者都是忽略掉数据，返回完成或者错误时间。
        ignoreElementTest();
        break;
      case R.id.ofTypeTest:
        // ignoreElements & ignoreElement（忽略元素）
        // ignoreElements 作用于Flowable、Observable。ignoreElement作用于Maybe、Single。两者都是忽略掉数据，返回完成或者错误时间。
        ofTypeTest();
        break;
      case R.id.sampleTest:
        // 作用于Flowable、Observable，在一个周期内发射最新的数据。
        sampleTest();
        break;
      case R.id.throttleFirstTest:
        // throttleFirst & throttleLast & throttleWithTimeout
        // 作用于Flowable、Observable。throttleLast与smaple一致，而throttleFirst是指定周期内第一个数据。throttleWithTimeout与debounce一致。
        throttleFirstTest();
        break;
      case R.id.throttleLatestTest:
        // 之所以拿出来单独说，我看不懂官网的解释。然后看别人的文章：throttleFirst+throttleLast的组合？开玩笑的吧。
        // 个人理解是：如果源的第一个数据总会被发射，然后开始周期计时，此时的效果就会跟throttleLast一致。
        throttleLatestTest();
        break;
      case R.id.takeAndtakeLastTest:
        // 作用于Flowable、Observable，take发射前n个元素;takeLast发射后n个元素。
        takeAndtakeLastTest();
        break;
      case R.id.timeoutTest:
        // timeout（超时）
        // 作用于Flowable、Observable、Maybe、Single、Completabl。后一个数据发射未在前一个元素发射后规定时间内发射则返回超时异常。
        timeoutTest();
        break;
      case R.id.startWithTest:
        // 可作用于Flowable、Observable。将指定数据源合并在另外数据源的开头。
        startWithTest();
        break;
      case R.id.mergeTest:
        // 可作用所有数据源类型，用于合并多个数据源到一个数据源。
        mergeTest();
        break;
      case R.id.zipTest:
        // 可作用于Flowable、Observable、Maybe、Single。将多个数据源的数据一个一个的合并在一起哇。
        // 当其中一个数据源发射完事件之后，若其他数据源还有数据未发射完毕，也会停止。
        zipTest();
        break;
      case R.id.bufferTest:
        // 作用于Flowable、Observable。指将数据源拆解含有长度为n的list的多个数据源，不够n的成为一个数据源。
        bufferTest();
        break;
      case R.id.castTest:
        // 作用于Flowable、Observable、Maybe、Single。将数据元素转型成其他类型,转型失败会抛出异常。
        castTest();
        break;
      case R.id.concatMapTest:
        // 作用于Flowable、Observable、Maybe。将数据源的元素作用于指定函数后，将函数的返回值有序的存在新的数据源。
        concatMapTest();
        break;
      case R.id.concatMapDelayErrorTest:
        // 与concatMap作用相同，只是将过程发送的所有错误延迟到最后处理。
        concatMapDelayErrorTest();
        break;
      case R.id.concatMapCompletableTest:
        // 作用于Flowable、Observable。与contactMap类似，不过应用于函数后，返回的是CompletableSource。
        // 订阅一次并在所有CompletableSource对象完成时返回一个Completable对象。
        concatMapCompletableTest();
        break;
      case R.id.concatMapCompletableDelayErrorTest:
        // 与concatMapCompletable作用相同，只是将过程发送的所有错误延迟到最后处理。
        concatMapCompletableDelayErrorTest();
        break;
      case R.id.flatMapTest:
        // 作用于Flowable、Observable、Maybe、Single。与contactMap类似，只是contactMap的数据发射是有序的，而flatMap是无序的。
        flatMapTest();
        break;
      case R.id.flattenAsFlowableAndFlattenAsObservableTest:
        // 作用于Maybe、Single，将其转化为Flowable，或Observable。
        flattenAsFlowableAndFlattenAsObservableTest();
        break;
      case R.id.groupByTest:
        // 作用于Flowable、Observable。根据一定的规则对数据源进行分组
        groupByTest();
        break;
      case R.id.scanTest:
        // 作用于Flowable、Observable。对数据进行相关联操作，例如聚合等。
        scanTest();
        break;
      case R.id.windowTest:
        // 对数据源发射出来的数据进行收集，按照指定的数量进行分组，以组的形式重新发射。
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
          windowTest();
        }
        break;
      case R.id.onErrorReturnTest:
        // 作用于Flowable、Observable、Maybe、Single。但调用数据源的onError函数后会回到该函数，可对错误进行处理，然后返回值，会调用观察者onNext()继续执行，执行完调用onComplete()函数结束所有事件的发射。
        onErrorReturnTest();
        break;
      case R.id.onErrorReturnItemTest:
        // 与onErrorReturn类似，onErrorReturnItem不对错误进行处理，直接返回一个值。
        onErrorReturnItemTest();
        break;
      case R.id.onExceptionResumeNextTest:
        // 可作用于Flowable、Observable、Maybe。onErrorReturn发生异常时，回调onComplete()函数后不再往下执行，
        // 而onExceptionResumeNext则是要在处理异常的时候返回一个数据源，然后继续执行，如果返回null，则调用观察者的onError()函数。
        // onExceptionResumeNext操作符也是类似的，只是捕获Exception。
        onExceptionResumeNextTest();
        break;
      case R.id.retryTest:
        // 可作用于所有的数据源，当发生错误时，数据源重复发射item，直到没有异常或者达到所指定的次数。
        retryTest();
        break;
      case R.id.retryUntilTest:
        // 作用于Flowable、Observable、Maybe。与retry类似，但发生异常时，返回值是false表示继续执行(重复发射数据)，true不再执行,但会调用onError方法。
        // retryWhen与此类似，但其判断标准不是BooleanSupplier对象的getAsBoolean()函数的返回值。而是返回的
        // Observable或Flowable是否会发射异常事件。
        retryUntilTest();
        break;
      default:
        break;
    }
  }

  /**
   * skip（跳过）
   *
   * <p>可以作用于Flowable,Observable，表示源发射数据前，跳过多少个。例如下面跳过前四个：
   */
  private void skipTest() {
    Observable<Integer> source = Observable.just(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    source.skip(4).subscribe(integer -> System.out.println("" + integer));
    // 打印结果：5678910

    // skipLast(n)操作表示从流的尾部跳过n个元素。
    Observable<Integer> source2 = Observable.just(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    source2.skipLast(4).subscribe(integer -> System.out.println("" + integer));
    //    打印结果：1 2 3 4 5 6
  }

  /**
   * debounce（去抖动）
   *
   * <p>可作用于Flowable,Observable。在Android开发，通常为了防止用户重复点击而设置标记位，而通过RxJava的debounce操作符可以有效达到该效果。
   * 在规定时间内，用户重复点击只有最后一次有效，
   */
  private void debounceTest() {
    Observable<String> source =
        Observable.create(
            emitter -> {
              emitter.onNext("A");

              Thread.sleep(1_500);
              emitter.onNext("B");

              Thread.sleep(500);
              emitter.onNext("C");

              Thread.sleep(250);
              emitter.onNext("D");

              Thread.sleep(2_000);
              emitter.onNext("E");
              emitter.onComplete();
            });
    source
        .subscribeOn(Schedulers.io())
        .debounce(1, TimeUnit.SECONDS)
        .blockingSubscribe(
            item -> System.out.print(item + " "),
            Throwable::printStackTrace,
            () -> System.out.println("onComplete"));

    // 打印：A D E onComplete
    // 上文代码中，数据源以一定的时间间隔发送A,B,C,D,E。操作符debounce的时间设为1秒，发送A后1.5秒并没有发射其他数据，所以A能成功发射。
    // 发射B后，在1秒之内，又发射了C和D,在D之后的2秒才发射E,所有B、C都失效，只有D有效；而E之后已经没有其他数据流了，所有E有效。
  }

  /**
   * distinct（去重）
   *
   * <p>可作用于Flowable,Observable，去掉数据源重复的数据。
   */
  private void distinctTest() {
    Observable.just(2, 3, 4, 4, 2, 1).distinct().subscribe(System.out::print);

    // 打印:2 3 4 1
    // distinctUntilChanged()去掉相邻重复数据。
    Observable.just(1, 1, 2, 1, 2, 3, 3, 4).distinctUntilChanged().subscribe(System.out::print);
    // 打印：1 2 1 2 3 4
  }

  /**
   * elementAt（获取指定位置元素）
   *
   * <p>可作用于Flowable,Observable，从数据源获取指定位置的元素，从0开始。
   */
  private void elementAtTest() {
    Observable.just(2, 4, 3, 1, 5, 8)
        .elementAt(0)
        .subscribe(integer -> Log.d("TAG", "elmentAt->" + integer));
    // 打印：2
    // elementAtOrError：指定元素的位置超过数据长度，则发射异常。
    Observable<String> source = Observable.just("Kirk", "Spock", "Chekov", "Sulu");
    Single<String> element = source.elementAtOrError(4);
    element.subscribe(
        name -> System.out.println("onSuccess will not be printed!"),
        error -> System.out.println("onError: " + error));
    // 打印：onSuccess will not be printed!
  }

  /**
   * filter（过滤）
   *
   * <p>可作用于 Flowable,Observable,Maybe,Single。在filter中返回表示发射该元素，返回false表示过滤该数据。
   */
  private void filterTest() {
    Observable.just(1, 2, 3, 4, 5, 6).filter(x -> x % 2 == 0).subscribe(System.out::print);
    // 打印：2 4 6
  }

  /**
   * first(第一个)
   *
   * <p>作用于 Flowable,Observable。发射数据源第一个数据，如果没有则发送默认值。
   */
  private void firstTest() {
    Observable<String> source = Observable.just("A", "B", "C");
    Single<String> firstOrDefault = source.first("D");
    firstOrDefault.subscribe(System.out::println);
    // 打印：A

    Observable<String> emptySource = Observable.empty();
    Single<String> firstOrError = emptySource.firstOrError();
    firstOrError.subscribe(
        element -> System.out.println("onSuccess will not be printed!"),
        error -> System.out.println("onError: " + error));
    // 打印：onError: java.util.NoSuchElementException
    // 和firstElement的区别是first返回的是Single，而firstElement返回Maybe。firstOrError在没有数据会返回异常。
  }

  /**
   * last(最后一个)
   *
   * <p>last、lastElement、lastOrError与fist、firstElement、firstOrError相对应。
   */
  private void lastTest() {
    Observable<String> source = Observable.just("A", "B", "C");
    Single<String> lastOrDefault = source.last("D");
    lastOrDefault.subscribe(System.out::println);
    // 打印:C

    Observable<String> source2 = Observable.just("A", "B", "C");
    Maybe<String> last = source2.lastElement();
    last.subscribe(System.out::println);
    // 打印:C

    Observable<String> emptySource = Observable.empty();
    Single<String> lastOrError = emptySource.lastOrError();
    lastOrError.subscribe(
        element -> System.out.println("onSuccess will not be printed!"),
        error -> System.out.println("onError: " + error));
    // 打印：onError: java.util.NoSuchElementException
  }

  /**
   * ignoreElements & ignoreElement（忽略元素）
   *
   * <p>ignoreElements 作用于Flowable、Observable。ignoreElement作用于Maybe、Single。两者都是忽略掉数据，返回完成或者错误时间。
   */
  private void ignoreElementTest() {
    Single<Long> source = Single.timer(1, TimeUnit.SECONDS);
    Completable completable = source.ignoreElement();
    completable.doOnComplete(() -> System.out.println("Done!")).blockingAwait();
    // 1秒后打印：Donde!

    Observable<Long> source2 = Observable.intervalRange(1, 5, 1, 1, TimeUnit.SECONDS);
    Completable completable2 = source2.ignoreElements();
    completable2.doOnComplete(() -> System.out.println("Done!")).blockingAwait();
    // 五秒后打印：Done!
  }

  /**
   * ofType（过滤掉类型）
   *
   * <p>作用于Flowable、Observable、Maybe、过滤掉类型。
   */
  private void ofTypeTest() {
    Observable<Number> numbers = Observable.just(1, 4.0, 3, 2.71, 2f, 7);
    Observable<Integer> integers = numbers.ofType(Integer.class);
    integers.subscribe((Integer x) -> System.out.print(x + " "));
    // 打印:1 3 7
  }

  /** 作用于Flowable、Observable，在一个周期内发射最新的数据。 */
  private void sampleTest() {
    Observable<String> source =
        Observable.create(
            emitter -> {
              emitter.onNext("A");

              Thread.sleep(500);
              emitter.onNext("B");

              Thread.sleep(200);
              emitter.onNext("C");

              Thread.sleep(800);
              emitter.onNext("D");

              Thread.sleep(600);
              emitter.onNext("E");
              emitter.onComplete();
            });

    source
        .subscribeOn(Schedulers.io())
        .sample(1, TimeUnit.SECONDS)
        .blockingSubscribe(
            item -> System.out.print(item + " "),
            Throwable::printStackTrace,
            () -> System.out.print("onComplete"));

    // 打印：C D onComplete
    // 与debounce的区别是，sample是以时间为周期的发射，一秒又一秒内的最新数据。而debounce是最后一个有效数据开始。
  }

  /**
   * throttleFirst & throttleLast & throttleWithTimeout
   *
   * <p>作用于Flowable、Observable。throttleLast与smaple一致，而throttleFirst是指定周期内第一个数据。throttleWithTimeout与debounce一致。
   */
  private void throttleFirstTest() {
    Observable<String> source =
        Observable.create(
            emitter -> {
              emitter.onNext("A");

              Thread.sleep(500);
              emitter.onNext("B");

              Thread.sleep(200);
              emitter.onNext("C");

              Thread.sleep(800);
              emitter.onNext("D");

              Thread.sleep(600);
              emitter.onNext("E");
              emitter.onComplete();
            });

    source
        .subscribeOn(Schedulers.io())
        .throttleFirst(1, TimeUnit.SECONDS)
        .blockingSubscribe(
            item -> System.out.print(item + " "),
            Throwable::printStackTrace,
            () -> System.out.print(" onComplete"));
    // 打印:A D onComplete

    source
        .subscribeOn(Schedulers.io())
        .throttleLast(1, TimeUnit.SECONDS)
        .blockingSubscribe(
            item -> System.out.print(item + " "),
            Throwable::printStackTrace,
            () -> System.out.print(" onComplete"));

    // 打印:C D onComplete
  }

  /**
   * 之所以拿出来单独说，我看不懂官网的解释。然后看别人的文章：throttleFirst+throttleLast的组合？开玩笑的吧。
   *
   * <p>个人理解是：如果源的第一个数据总会被发射，然后开始周期计时，此时的效果就会跟throttleLast一致。
   */
  private void throttleLatestTest() {
    Observable<String> source =
        Observable.create(
            emitter -> {
              emitter.onNext("A");

              Thread.sleep(500);
              emitter.onNext("B");

              Thread.sleep(200);
              emitter.onNext("C");

              Thread.sleep(200);
              emitter.onNext("D");

              Thread.sleep(400);
              emitter.onNext("E");

              Thread.sleep(400);
              emitter.onNext("F");

              Thread.sleep(400);
              emitter.onNext("G");

              Thread.sleep(2000);
              emitter.onComplete();
            });
    source
        .subscribeOn(Schedulers.io())
        .throttleLatest(1, TimeUnit.SECONDS)
        .blockingSubscribe(
            item -> Log.e("RxJava", item),
            Throwable::printStackTrace,
            () -> Log.e("RxJava", "finished"));
  }

  /** 作用于Flowable、Observable，take发射前n个元素;takeLast发射后n个元素。 */
  private void takeAndtakeLastTest() {
    Observable<Integer> source = Observable.just(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    source.take(4).subscribe(System.out::print);
    // 打印:1 2 3 4

    source.takeLast(4).subscribe(System.out::println);
    // 打印:7 8 9 10
  }

  /**
   * timeout（超时）
   *
   * <p>作用于Flowable、Observable、Maybe、Single、Completabl。后一个数据发射未在前一个元素发射后规定时间内发射则返回超时异常。
   */
  private void timeoutTest() {
    Observable<String> source =
        Observable.create(
            emitter -> {
              emitter.onNext("A");

              Thread.sleep(800);
              emitter.onNext("B");

              Thread.sleep(400);
              emitter.onNext("C");

              Thread.sleep(1200);
              emitter.onNext("D");
              emitter.onComplete();
            });

    source
        .timeout(1, TimeUnit.SECONDS)
        .subscribe(
            item -> System.out.println("onNext: " + item),
            error -> System.out.println("onError: " + error),
            () -> System.out.println("onComplete will not be printed!"));
    // 打印:
    // onNext: A
    // onNext: B
    // onNext: C
    // onError: java.util.concurrent.TimeoutException:
    // The source did not signal an event for 1 seconds
    // and has been terminated.
  }

  /** 可作用于Flowable、Observable。将指定数据源合并在另外数据源的开头。 */
  private void startWithTest() {
    Observable<String> names = Observable.just("Spock", "McCoy");
    Observable<String> otherNames = Observable.just("Git", "Code", "8");
    names.startWith(otherNames).subscribe(item -> Log.d(TAG, item));

    // 打印：
    // RxJava: Git
    // RxJava: Code
    // RxJava: 8
    // RxJava: Spock
    // RxJava: McCo

  }

  /** 可作用所有数据源类型，用于合并多个数据源到一个数据源。 */
  private void mergeTest() {
    Observable<String> names = Observable.just("Hello", "world");
    Observable<String> otherNames = Observable.just("Git", "Code", "8");

    Observable.merge(names, otherNames).subscribe(name -> Log.d(TAG, name));

    // 也可以是
    // names.mergeWith(otherNames).subscribe(name -> Log.d(TAG,name));

    // 打印：
    // RxJava: Hello
    // RxJava: world
    // RxJava: Git
    // RxJava: Code
    // RxJava: 8

    // merge在合并数据源时，如果一个合并发生异常后会立即调用观察者的onError方法，并停止合并。可通过mergeDelayError操作符，将发生的异常留到最后处理。
    Observable<String> names2 = Observable.just("Hello", "world");
    Observable<String> otherNames2 = Observable.just("Git", "Code", "8");
    Observable<String> error2 = Observable.error(new NullPointerException("Error!"));
    Observable.mergeDelayError(names2, error2, otherNames2)
        .subscribe(name -> Log.d(TAG, name), e -> Log.d(TAG, e.getMessage()));

    // 打印：
    // RxJava: Hello
    // RxJava: world
    // RxJava: Git
    // RxJava: Code
    // RxJava: 8
    // RxJava: Error!

  }

  /**
   * 可作用于Flowable、Observable、Maybe、Single。将多个数据源的数据一个一个的合并在一起哇。当其中一个数据源发射完事件之后，若其他数据源还有数据未发射完毕，也会停止。
   */
  private void zipTest() {
    Observable<String> names = Observable.just("Hello", "world");
    Observable<String> otherNames = Observable.just("Git", "Code", "8");
    names
        .zipWith(otherNames, (first, last) -> first + "-" + last)
        .subscribe(item -> Log.d(TAG, item));

    // 打印：
    // RxJava: Hello-Git
    // RxJava: world-Code
  }

  /** 作用于Flowable、Observable。指将数据源拆解含有长度为n的list的多个数据源，不够n的成为一个数据源。 */
  private void bufferTest() {
    Observable.range(0, 10)
        .buffer(4)
        .subscribe((List<Integer> buffer) -> System.out.println(buffer));
    // 打印:
    // [0, 1, 2, 3]
    // [4, 5, 6, 7]
    // [8, 9]
  }

  /** 作用于Flowable、Observable、Maybe、Single。将数据元素转型成其他类型,转型失败会抛出异常。 */
  private void castTest() {
    Observable<Number> numbers = Observable.just(1, 4.0, 3f, 7, 12, 4.6, 5);

    numbers
        .filter((Number x) -> Integer.class.isInstance(x))
        .cast(Integer.class)
        .subscribe((Integer x) -> System.out.println(x));
    // prints:
    // 1
    // 7
    // 12
    // 5

  }

  /** 作用于Flowable、Observable、Maybe。将数据源的元素作用于指定函数后，将函数的返回值有序的存在新的数据源。 */
  private void concatMapTest() {
    Observable.range(0, 5)
        .concatMap(
            i -> {
              long delay = Math.round(Math.random() * 2);

              return Observable.timer(delay, TimeUnit.SECONDS).map(n -> i);
            })
        .blockingSubscribe(System.out::print);

    // prints 01234

  }

  /** 与concatMap作用相同，只是将过程发送的所有错误延迟到最后处理。 */
  private void concatMapDelayErrorTest() {
    Observable.intervalRange(1, 3, 0, 1, TimeUnit.SECONDS)
        .concatMapDelayError(
            x -> {
              if (x.equals(1L)) {
                return Observable.error(new IOException("Something went wrong!"));
              } else {
                return Observable.just(x, x * x);
              }
            })
        .blockingSubscribe(
            x -> System.out.println("onNext: " + x),
            error -> System.out.println("onError: " + error.getMessage()));
    // prints:
    // onNext: 2
    // onNext: 4
    // onNext: 3
    // onNext: 9
    // onError: Something went wrong!
  }

  /**
   * 作用于Flowable、Observable。与contactMap类似，不过应用于函数后，返回的是CompletableSource。订阅一次并在所有CompletableSource对象完成时返回一个Completable对象。
   */
  private void concatMapCompletableTest() {
    Observable<Integer> source = Observable.just(2, 1, 3);
    Completable completable =
        source.concatMapCompletable(
            x -> {
              return Completable.timer(x, TimeUnit.SECONDS)
                  .doOnComplete(
                      () -> System.out.println("Info: Processing of item \"" + x + "\" completed"));
            });

    completable
        .doOnComplete(() -> System.out.println("Info: Processing of all items completed"))
        .blockingAwait();

    // prints:
    // Info: Processing of item "2" completed
    // Info: Processing of item "1" completed
    // Info: Processing of item "3" completed
    // Info: Processing of all items completed
  }

  /** 与concatMapCompletable作用相同，只是将过程发送的所有错误延迟到最后处理。 */
  private void concatMapCompletableDelayErrorTest() {
    Observable<Integer> source = Observable.just(2, 1, 3);
    Completable completable =
        source.concatMapCompletableDelayError(
            x -> {
              if (x.equals(2)) {
                return Completable.error(
                    new IOException("Processing of item \"" + x + "\" failed!"));
              } else {
                return Completable.timer(1, TimeUnit.SECONDS)
                    .doOnComplete(
                        () ->
                            System.out.println("Info: Processing of item \"" + x + "\" completed"));
              }
            });

    completable
        .doOnError(error -> System.out.println("Error: " + error.getMessage()))
        .onErrorComplete()
        .blockingAwait();

    // prints:
    // Info: Processing of item "1" completed
    // Info: Processing of item "3" completed
    // Error: Processing of item "2" failed!
  }

  /** 作用于Flowable、Observable、Maybe、Single。与contactMap类似，只是contactMap的数据发射是有序的，而flatMap是无序的。 */
  private void flatMapTest() {
    Observable.just("A", "B", "C")
        .flatMap(
            a -> {
              return Observable.intervalRange(1, 3, 0, 1, TimeUnit.SECONDS)
                  .map(b -> '(' + a + ", " + b + ')');
            })
        .blockingSubscribe(System.out::println);

    // prints (not necessarily in this order):
    // (A, 1)
    // (C, 1)
    // (B, 1)
    // (A, 2)
    // (C, 2)
    // (B, 2)
    // (A, 3)
    // (C, 3)
    // (B, 3)
  }

  /** 作用于Maybe、Single，将其转化为Flowable，或Observable。 */
  @SuppressLint("CheckResult")
  private void flattenAsFlowableAndFlattenAsObservableTest() {
    Single<Double> source = Single.just(2.0);
    Flowable<Double> flowable =
        source.flattenAsFlowable(
            x -> {
              return Arrays.asList(x, Math.pow(x, 2), Math.pow(x, 3));
            });
    flowable.subscribe(x -> System.out.println("onNext: " + x));

    // prints:
    // onNext: 2.0
    // onNext: 4.0
    // onNext: 8.0
  }

  /** 作用于Flowable、Observable。根据一定的规则对数据源进行分组 */
  private void groupByTest() {
    Observable<String> animals =
        Observable.just(
            "Tiger", "Elephant", "Cat", "Chameleon", "Frog", "Fish", "Turtle", "Flamingo");

    animals
        .groupBy(animal -> animal.charAt(0), String::toUpperCase)
        .concatMapSingle(Observable::toList)
        .subscribe(System.out::println);

    // prints:
    // [TIGER, TURTLE]
    // [ELEPHANT]
    // [CAT, CHAMELEON]
    // [FROG, FISH, FLAMINGO]
  }

  /** 作用于Flowable、Observable。对数据进行相关联操作，例如聚合等。 */
  private void scanTest() {
    Observable.just(5, 3, 8, 1, 7)
        .scan(0, (partialSum, x) -> partialSum + x)
        .subscribe(System.out::println);

    // prints:
    // 0
    // 5
    // 8
    // 16
    // 17
    // 24
  }

  /** 对数据源发射出来的数据进行收集，按照指定的数量进行分组，以组的形式重新发射。 */
  @RequiresApi(api = Build.VERSION_CODES.N)
  @SuppressLint("CheckResult")
  private void windowTest() {
    Observable.range(1, 4)
        // Create windows containing at most 2 items, and skip 3 items before starting a new window.
        .window(2)
        .flatMapSingle(
            window -> {
              return window
                  .map(String::valueOf)
                  .reduce(new StringJoiner(", ", "[", "]"), StringJoiner::add);
            })
        .subscribe(System.out::println);

    // prints:
    // [1, 2]
    // [3, 4]
  }

  /**
   * 作用于Flowable、Observable、Maybe、Single。但调用数据源的onError函数后会回到该函数，可对错误进行处理，然后返回值，会调用观察者onNext()继续执行，执行完调用onComplete()函数结束所有事件的发射。
   */
  private void onErrorReturnTest() {
    Single.just("2A")
        .map(v -> Integer.parseInt(v, 10))
        .onErrorReturn(
            error -> {
              if (error instanceof NumberFormatException) {
                return 0;
              }
              throw new IllegalArgumentException();
            })
        .subscribe(
            System.out::println, error -> System.err.println("onError should not be printed!"));

    // prints 0
  }

  /** 与onErrorReturn类似，onErrorReturnItem不对错误进行处理，直接返回一个值。 */
  private void onErrorReturnItemTest() {
    Single.just("2A")
        .map(v -> Integer.parseInt(v, 10))
        .onErrorReturnItem(0)
        .subscribe(
            System.out::println, error -> System.err.println("onError should not be printed!"));

    // prints 0
  }

  /**
   * 可作用于Flowable、Observable、Maybe。onErrorReturn发生异常时，回调onComplete()函数后不再往下执行，
   * 而onExceptionResumeNext则是要在处理异常的时候返回一个数据源，然后继续执行，如果返回null，则调用观察者的onError()函数。
   * onExceptionResumeNext操作符也是类似的，只是捕获Exception。
   */
  private void onExceptionResumeNextTest() {
    Observable.create(
            (ObservableOnSubscribe<Integer>)
                e -> {
                  e.onNext(1);
                  e.onNext(2);
                  e.onNext(3);
                  e.onError(new NullPointerException());
                  e.onNext(4);
                })
        .onErrorResumeNext(
            throwable -> {
              Log.d(TAG, "onErrorResumeNext ");
              return Observable.just(4);
            })
        .subscribe(
            new Observer<Integer>() {
              @Override
              public void onSubscribe(Disposable d) {
                Log.d(TAG, "onSubscribe ");
              }

              @Override
              public void onNext(Integer integer) {
                Log.d(TAG, "onNext " + integer);
              }

              @Override
              public void onError(Throwable e) {
                Log.d(TAG, "onError ");
              }

              @Override
              public void onComplete() {
                Log.d(TAG, "onComplete ");
              }
            });
  }

  /** 可作用于所有的数据源，当发生错误时，数据源重复发射item，直到没有异常或者达到所指定的次数。 */
  private void retryTest() {
    final boolean[] first = {true};

    Observable.create(
            (ObservableOnSubscribe<Integer>)
                e -> {
                  e.onNext(1);
                  e.onNext(2);

                  if (first[0]) {
                    first[0] = false;
                    e.onError(new NullPointerException());
                  }
                })
        .retry(9)
        .subscribe(
            new Observer<Integer>() {
              @Override
              public void onSubscribe(Disposable d) {
                Log.d(TAG, "onSubscribe ");
              }

              @Override
              public void onNext(Integer integer) {
                Log.d(TAG, "onNext " + integer);
              }

              @Override
              public void onError(Throwable e) {
                Log.d(TAG, "onError ");
              }

              @Override
              public void onComplete() {
                Log.d(TAG, "onComplete ");
              }
            });
  }

  /**
   * 作用于Flowable、Observable、Maybe。与retry类似，但发生异常时，返回值是false表示继续执行(重复发射数据)，true不再执行,但会调用onError方法。
   * retryWhen与此类似，但其判断标准不是BooleanSupplier对象的getAsBoolean()函数的返回值。而是返回的
   * Observable或Flowable是否会发射异常事件。
   */
  private void retryUntilTest() {
    Observable.create(
            (ObservableOnSubscribe<Integer>)
                e -> {
                  e.onNext(1);
                  e.onNext(2);
                  e.onError(new NullPointerException());
                  e.onNext(3);
                  e.onComplete();
                })
        .retryUntil(() -> true)
        .subscribe(
            new Observer<Integer>() {
              @Override
              public void onSubscribe(Disposable d) {
                Log.d(TAG, "onSubscribe ");
              }

              @Override
              public void onNext(Integer integer) {
                Log.d(TAG, "onNext " + integer);
              }

              @Override
              public void onError(Throwable e) {
                Log.d(TAG, "onError ");
              }

              @Override
              public void onComplete() {
                Log.d(TAG, "onComplete ");
              }
            });
  }
}
